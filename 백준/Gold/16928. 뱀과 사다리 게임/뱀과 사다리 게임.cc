#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int x, y;
    int dp[101];
    unordered_map<int, int> ledderIn;	// 키-값이 사다리 출발-도착
    unordered_map<int, int> ledderOut;	// 키-값이 사다리 도착-출발
    unordered_map<int, int> snake;
    
    // 입력
    cin >> n >> m;
    for(int i=0; i<n; i++){
        cin >> x >> y;
        ledderIn.emplace(x, y);
        ledderOut.emplace(y, x);
    }
    for(int i=0; i<m; i++){
        cin >> x >> y;
        snake.emplace(x, y);
    }
    
    // 기본값 넣기
    for(int i=2; i<=7; i++)
        dp[i]=1;
    
    // dp
    for(int i=8; i<=100; i++){
        vector<int> pre;	// 최솟값 후보 저장
        
        // 이전 6칸중 사다리나 뱀의 출발부가 아닌 칸이 최솟값 후보가 됨
        for(int j=6; j>0; j--)
        	if(!ledderIn.count(i-j) && !snake.count(i-j))
        		pre.push_back(dp[i-j]+1);
                
        // 해당칸이 사다리 도착 지점이라면 사다리 출발 지점의 dp값도 최솟값 후보
        if(ledderOut.count(i)) pre.push_back(dp[ledderOut[i]]);
        dp[i]=*min_element(pre.begin(), pre.end());
		
        // 뱀칸일때 dp값이 출발지점 < 도착지점 이면 최솟값 갱신 후 도착 지점에서 다시 출발
        if(snake.count(i) && dp[i] < dp[snake[i]]){
            dp[snake[i]] = dp[i];
            i = snake[i];
        }
    }

    cout << dp[100];
    
    return 0;
}