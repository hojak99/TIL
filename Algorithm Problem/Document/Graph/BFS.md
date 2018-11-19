# BFS
BFS 의 목적은 임의의 정점에서 시작해서, 모든 정점을 한 번씩 방문하는 것이다. 그렇지만 BFS 는 최단거리를 구하는 알고리즘으로 사용된다.

BFS 로 최단거리를 구하려면 우선 `모든 가중치가 1일 때`라는 전제조건이 있어야 한다.

왜냐하면 BFS 는 모든 간선을 큐에 넣고 그 연결된 모든 간선을 탐색하기 때문이다.

그렇기 때문에 우리는 BFS 를 이용해서 최단거리를 구할 수가 있다.

---

## BFS 를 이용해 해결할 수 있는 문제
BFS 를 이용해 해결할 수 있는 문제는 다음과 같은 조건을 만족해야 한다.

1. 최소 비용 문제
2. 간선의 가중치가 1
3. 정점과 간선의 개수가 적어야 함. (시간 제한, 메모리 제한)

`최소 비용 = 최단 거리의 거리` 는 같아야 한다. 

---

## 예제

백준 2178 문제를 살펴보자. 미로찾기 문제다.

```
#include <iostream>
#include <queue>

int main() {
	// 접근 가능한 간선이라고 생각하면 됨
	int dx[] = { 0, 0, 1, -1 };
	int dy[] = { 1, -1, 0, 0 };

	// 미로가 들어갈 배열
	int arr[100][100];

	// 접근했는지 안했는지 체크해주는 배열
	bool check[100][100] = { false };

	// 총 거리의 가중치를 넣는 배열
	int dist[100][100];

	int n = 0;
	int m = 0;

	std::cin >> n;
	std::cin >> m;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			scanf_s("%1d", &arr[i][j]);
		}
	}

	std::queue<std::pair<int, int>> q;
	q.push(std::make_pair(0, 0));		// 시작점 (0, 0)
	check[0][0] = true;		// 시작점
	dist[0][0] = 1;			// 시작점

	while (!q.empty()) {
		int x = q.front().first;	// 처음에 들어간 x
		int y = q.front().second;	// 처음에 들어간 y

		q.pop();

		for (int k = 0; k < 4; ++k) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			// out of index 를 방지하기 위한 if 문
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {

				// 방문하지 않았고, 접근할 수 있는 index (1 일 때) 일 때
				if (check[nx][ny] == false && arr[nx][ny] == 1) {
					check[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
					q.push(std::make_pair(nx, ny));
				}
			}
		}
	}


	std::cout << dist[n - 1][m - 1];
	return 0;
}
```

여기서 머리가 좋아지는 느낌이 든다. 처음에 필자도 이해가 잘 안가서 공책에 써보면서 손코딩 해보니까 이해가 잘 됐다.

이렇게 대놓고 BFS 를 이용해 풀어라! 하는 문제는 괜찮지만 조금 더 심화된 문제들은 조금 더 연습이 필요해보인다.