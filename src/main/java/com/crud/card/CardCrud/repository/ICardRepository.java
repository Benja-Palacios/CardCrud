package com.crud.card.CardCrud.repository;

import com.crud.card.CardCrud.model.Card;

import java.util.List;

public interface ICardRepository {
    public List<Card> findAll();
    public int save(Card card);
    public int update(Card card);
    public int deleteById(int id);

}
