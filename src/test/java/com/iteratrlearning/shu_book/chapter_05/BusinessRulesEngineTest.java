package com.iteratrlearning.shu_book.chapter_05;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.iteratrlearning.shu_book.chapter05.Action;
import com.iteratrlearning.shu_book.chapter05.BusinessRuleEngine;

import static org.mockito.Mockito.*;

public class BusinessRulesEngineTest {

    @Test
    public void shouldHaveNoRulesInitially() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    public void shouldAddTwoActions() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});
        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    public void shouldExecuteOneAction() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        final Action mockAction = mock(Action.class);
        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();
        verify(mockAction).perform();
    }

    @Test
    public void shouldPerformAnActionWithFacts() {
        final Action mockAction = mock(Action.class);
        final Facts mockFacts = mock(Fact.class);
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockedFacts);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).perform(mockFacts);
    }

}
