package blackjack.domain.participant;

import blackjack.domain.Card;
import blackjack.domain.GivenCards;
import blackjack.domain.enums.Score;
import blackjack.domain.enums.Suit;
import blackjack.domain.state.finished.Blackjack;
import blackjack.domain.state.finished.Burst;
import blackjack.domain.state.finished.Stay;
import blackjack.domain.state.running.Hit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    @DisplayName("처음 받은 카드 두 장의 합이 21일 경우, Blackjack 상태가 된다.")
    void create_state_blackjack() {
        //given
        Card card1 = new Card(Score.A, Suit.DIAMOND);
        Card card2 = new Card(Score.TEN, Suit.DIAMOND);
        GivenCards givenCards = new GivenCards(Arrays.asList(card1, card2));

        //when
        Person dealer = new Dealer("딜러", givenCards);

        //then
        assertThat(dealer).extracting("state")
                .isInstanceOf(Blackjack.class);
    }

    @Test
    @DisplayName("처음 받은 카드 두 장의 합이 16 이하일 경우, Hit 상태가 된다.")
    void create_state_hit() {
        //given
        Card card1 = new Card(Score.TEN, Suit.DIAMOND);
        Card card2 = new Card(Score.SIX, Suit.CLUB);
        GivenCards givenCards = new GivenCards(Arrays.asList(card1, card2));

        //when
        Person dealer = new Dealer("딜러", givenCards);

        //then
        assertThat(dealer).extracting("state")
                .isInstanceOf(Hit.class);
    }

    @Test
    @DisplayName("처음 받은 카드 두 장의 합이 16을 초과할 경우, Stay 상태가 된다.")
    void create_state_stay() {
        //given
        Card card1 = new Card(Score.TEN, Suit.DIAMOND);
        Card card2 = new Card(Score.SEVEN, Suit.CLUB);
        GivenCards givenCards = new GivenCards(Arrays.asList(card1, card2));

        //when
        Person dealer = new Dealer("딜러", givenCards);

        //then
        assertThat(dealer).extracting("state")
                .isInstanceOf(Stay.class);
    }

    @Test
    @DisplayName("발급 받은 카드를 더한 합이 21을 초과할 경우, Burst 상태가 된다.")
    void hit_become_burst_state() {
        //given
        Card card1 = new Card(Score.TEN, Suit.DIAMOND);
        Card card2 = new Card(Score.SIX, Suit.CLUB);
        GivenCards givenCards = new GivenCards(Arrays.asList(card1, card2));
        Person dealer = new Dealer("pobi", givenCards);
        Card card3 = new Card(Score.SIX, Suit.HEART);

        //when
        dealer.hit(card3);

        //then
        assertThat(dealer).extracting("state")
                .isInstanceOf(Burst.class);
    }

    @Test
    @DisplayName("발급 받은 카드를 더한 합이 21 이하일 경우, Hit 상태가 된다.")
    void hit_remain_hit_state() {
        //given
        Card card1 = new Card(Score.TEN, Suit.DIAMOND);
        Card card2 = new Card(Score.SIX, Suit.DIAMOND);
        GivenCards givenCards = new GivenCards(Arrays.asList(card1, card2));
        Person dealer = new Dealer("pobi", givenCards);
        Card card3 = new Card(Score.FIVE, Suit.HEART);

        //when
        dealer.hit(card3);

        //then
        assertThat(dealer).extracting("state")
                .isInstanceOf(Hit.class);
    }
}