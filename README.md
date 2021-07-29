# java-blackjack

# 규칙
Blackjack : 처음 두 장의 카드 합 21 => 승
Bust : 카드 합 21 초과 => 패
Push : 플레이어, 딜러 카드 합이 같음 => 무승부
Hit : 플레이어의 카드 2장의 합이 21을 초과하지 않을 경우, 추가 카드를 요청
Stay : 플레이어가 추가 카드를 원하지 않음, 딜러는 카드 합 17 이상이면 추가 카드를 얻을 수 없음

# 구현해야 할 기능 목록
- [] 입력
    - [] 플레이어 이름
    - [] 플레이어(딜러 제외) 추가 카드 요청 여부

- [] 출력
    - [] 각 플레이어(딜러 포함)에게 2장의 카드 지급 알림
    - [] 각 플레이어(딜러 포함)가 가진 카드
    - [] 딜러의 추가 카드 지급 여부 결과
    - [] 각 플레이어(딜러 포함)의 총 카드의 합
    - [] 최종 승패 결과

- [] 상태
    - 기능
        - [] 첫 카드 2장 발급
        - [] 추가 카드 발급
        - [] 추가 카드 발급 거부
        - [] 모든 카드 합 계산
        - [] 게임 종료 상태인지 확인

- [] 게임 참여 상태 (Running)
    - [] 시작 상태
    - [] 카드 추가 받은 상태

- [] 게임 종료 상태 (Finished)
    - [] Blackjack 상태
    - [] Burst 상태
    - [] Stay 상태

- [] 플레이어
    - 속성
        - [] 이름
        - [] 카드 목록

    - 기능
        - [] 초기 카드 2장을 받는다
        - [] 카드 추가 요청

- [] 딜러
    - 속성
        - [] 이름
        - [] 카드 목록

    - 기능
        - [] 초기 카드 2장을 받는다
        - [] 카드 추가 요청
            - [] ERROR: 합이 17 이상이면 추가 카드를 얻을 수 없음

- [x] 카드
    - 속성
        - [x] 점수
        - [x] 무늬

    - 기능
        - [x] 카드의 값 반환
        - [x] ACE인지 확인

- [x] 점수 enum
    - 속성
        - [x] 점수 이름(끗수)
        - [x] 점수

    - 기능
        - [x] 점수 이름 반환
        - [x] 점수 반환
        - [x] ACE인지 확인

- [x] 무늬 enum - 속성 - [x] 무늬

      - 기능
          - [x] 무늬 이름 반환

- [] 현재까지 받은 카드 목록
    - 속성
        - [] 현재까지 받은 카드 목록

    - 기능
        - [] Ace 포함하는지 확인
        - [] 처음 두 장의 카드 합 21인지 확인
        - [] 모든 카드 합이 21을 초과하는지 확인
        - [] 21을 기준으로 Ace 1 또는 11로 설정

- [] 카드 덱
    - 속성
        - [] 카드 52장

    - 기능
        - [] 52장 카드 생성
        - [] 처음 2장 카드 반환
        - [] 추가 카드 반환
            - [] ERROR: 반환할 수 있는 카드가 없을 경우

- [] 게임 시스템
    - 속성
        - [] 참여자 목록

    - 기능
        - [] 카드 지급
        - [] 참여자 점수 비교
