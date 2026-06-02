# Algorithm

> 자료구조 & 알고리즘 학습 저장소 — 코딩테스트 문제 풀이와 핵심 알고리즘을 Java로 직접 구현합니다.

현재 **866개**의 Java 풀이가 출처/난이도별로 정리되어 있습니다.

## 🗂 구성

```
src/main/java/com/study/algorithm
├── site/            # 온라인 저지 풀이
│   ├── programmers/ # 프로그래머스 (level_0 / 1 / 2 / unlevel)
│   ├── backjoon/    # 백준 (단계별 step: 정렬·스택큐덱·집합과맵·브루트포스·DP·백트래킹·누적합 등)
│   └── leetCode/    # LeetCode
├── book/            # 교재 기반 학습
│   ├── codingtest_learn/  # 『Do it! 코딩 테스트』 (배열·스택·큐·해시·트리·그래프·백트래킹·정렬 …)
│   ├── doit_intro/        # 입문편
│   └── doit_middle/       # 중급편 (그래프·정수론·조합 …)
├── inflearn/        # 인프런 강의 (intro / middle)
│   ├── intro/       # 문자열·배열·투포인터·정렬·스택큐·재귀·DFS/BFS·그리디·DP
│   └── middle/      # 시뮬레이션·해싱·자료구조·정렬·그리디·DFS/BFS·그래프
└── personal/        # 개인 학습 (DFS·BFS·그리디 / Stream·Lambda 등 Java 문법 연습)
```

## 📌 다루는 주제

- **자료구조**: 배열, 스택/큐/덱, 해시, 트리, 집합(Union-Find), 그래프
- **알고리즘**: 정렬, 완전탐색(브루트포스), DFS/BFS, 다익스트라, 백트래킹, 그리디, 동적계획법(DP), 투포인터, 누적합, 조합론, 정수론
- **Java**: Stream / Lambda 등 언어 기능 연습

## 🛠 Environment

- Java / Gradle (Kotlin DSL, `build.gradle.kts`)
- 테스트: JUnit 5, AssertJ

## ▶️ 실행

```bash
./gradlew build
# 개별 풀이는 각 Main 클래스의 main() 실행
```
