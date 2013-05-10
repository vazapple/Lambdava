/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.lambdava.tuple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An immutable pair consisting of two elements.
 * <p>
 * This implementation refers to the elements as 'first' and 'second'.
 * The class also implements the {@code Map.Entry} interface where the key is 'first'
 * and the value is 'second'.
 * <p>
 * Although the implementation is immutable, there is no restriction on the objects
 * that may be stored. If mutable objects are stored in the pair, then the pair itself
 * effectively becomes mutable.
 *
 * @param <A> the first element type
 * @param <B> the second element type
 */
public abstract class Pair<A, B> implements Serializable {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * Creates a pair of {@code Object}s inferring the types.
   *
   * @param <A> the first element type
   * @param <B> the second element type
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static <A, B> ObjectsPair<A, B> of(A first, B second) {
    return new ObjectsPair<A, B>(first, second);
  }

  /**
   * Creates a pair of {@code Double}s.
   *
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static ObjectsPair<Double, Double> of(Double first, double second) {
    return new ObjectsPair<Double, Double>(first, second);
  }

  /**
   * Creates a pair of {@code Double}s.
   *
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static ObjectsPair<Double, Double> of(double first, Double second) {
    return new ObjectsPair<Double, Double>(first, second);
  }

  /**
   * Creates a pair of {@code double}s.
   *
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static DoublesPair of(double first, double second) {
    return new DoublesPair(first, second);
  }

  /**
   * Creates a pair of {@code int} to {@code double}.
   *
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static IntDoublePair of(int first, double second) {
    return new IntDoublePair(first, second);
  }

  /**
   * Creates a pair of {@code int} to {@code int}.
   *
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static IntDoublePair of(int first, int second) {
    return new IntDoublePair(first, second);
  }

  /**
   * Creates a pair of {@code long} to {@code double}.
   *
   * @param first  the first element, may be null
   * @param second  the second element, may be null
   * @return a pair formed from the two parameters, not null
   */
  public static LongDoublePair of(long first, double second) {
    return new LongDoublePair(first, second);
  }

  /**
   * Constructs a pair.
   */
  protected Pair() {
  }

  //-------------------------------------------------------------------------

  /**
   * Gets the first element from this pair.
   * <p>
   * When treated as a key-value pair, this is the key.
   *
   * @return the first element, may be null
   */
  public abstract A getFirst();


  /**
   * Gets the second element from this pair.
   * <p>
   * When treated as a key-value pair, this is the value.
   *
   * @return the second element, may be null
   */
  public abstract B getSecond();

  /**
   * Alias fo getFirst()
   * @return the second element, may be null 
   */
  public A _1() {
    return getFirst();
  }

  /**
   * Alias fo getSecond()
   * @return the second element, may be null 
   */
  public B _2() {
    return getSecond();
  }

  //-------------------------------------------------------------------------

  /**
   * Gets the elements from this pair as a list.
   * <p>
   * This method supports auto-casting as they is no way in generics to provide
   * a more specific type.
   *
   * @param <T> an auto-cast list type
   * @return the elements as a list, not null
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> toList() {
    ArrayList<Object> list = new ArrayList<Object>();
    list.add(getFirst());
    list.add(getSecond());
    return (List<T>) list;
  }


  @Override
  public boolean equals(Object obj) {
    // see Map.Entry API specification
    if (this == obj) {
      return true;
    }
    if (obj instanceof Pair<?, ?>) {
      Pair<?, ?> other = (Pair<?, ?>) obj;
      return
        ((_1() == null && other._1() == null) || (_1() == other._1()) || (_1() != null && _1().equals(other._1())))
          &&
          ((_2() == null && other._2() == null) || (_2() == other._2()) || (_2() != null && _2().equals(other._2())));
    }
    return false;
  }

  @Override
  public int hashCode() {
    // see Map.Entry API specification
    return (getFirst() == null ? 0 : getFirst().hashCode()) ^
      (getSecond() == null ? 0 : getSecond().hashCode());
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("(")
      .append(getFirst())
      .append(", ")
      .append(getSecond())
      .append(")").toString();
  }

}
