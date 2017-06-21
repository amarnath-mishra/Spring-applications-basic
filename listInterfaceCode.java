Save This PageHome » openjdk-7 » java » util » [javadoc | source]
   1   /*
   2    * Copyright (c) 1997, 2010, Oracle and/or its affiliates. All rights reserved.
   3    * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
   4    *
   5    * This code is free software; you can redistribute it and/or modify it
   6    * under the terms of the GNU General Public License version 2 only, as
   7    * published by the Free Software Foundation.  Oracle designates this
   8    * particular file as subject to the "Classpath" exception as provided
   9    * by Oracle in the LICENSE file that accompanied this code.
  10    *
  11    * This code is distributed in the hope that it will be useful, but WITHOUT
  12    * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
  13    * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
  14    * version 2 for more details (a copy is included in the LICENSE file that
  15    * accompanied this code).
  16    *
  17    * You should have received a copy of the GNU General Public License version
  18    * 2 along with this work; if not, write to the Free Software Foundation,
  19    * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
  20    *
  21    * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
  22    * or visit www.oracle.com if you need additional information or have any
  23    * questions.
  24    */
  25
  26   package java.util;
  27
  28   /**
  29    * An ordered collection (also known as a <i>sequence</i>).  The user of this
  30    * interface has precise control over where in the list each element is
  31    * inserted.  The user can access elements by their integer index (position in
  32    * the list), and search for elements in the list.<p>
  33    *
  34    * Unlike sets, lists typically allow duplicate elements.  More formally,
  35    * lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt>
  36    * such that <tt>e1.equals(e2)</tt>, and they typically allow multiple
  37    * null elements if they allow null elements at all.  It is not inconceivable
  38    * that someone might wish to implement a list that prohibits duplicates, by
  39    * throwing runtime exceptions when the user attempts to insert them, but we
  40    * expect this usage to be rare.<p>
  41    *
  42    * The <tt>List</tt> interface places additional stipulations, beyond those
  43    * specified in the <tt>Collection</tt> interface, on the contracts of the
  44    * <tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and
  45    * <tt>hashCode</tt> methods.  Declarations for other inherited methods are
  46    * also included here for convenience.<p>
  47    *
  48    * The <tt>List</tt> interface provides four methods for positional (indexed)
  49    * access to list elements.  Lists (like Java arrays) are zero based.  Note
  50    * that these operations may execute in time proportional to the index value
  51    * for some implementations (the <tt>LinkedList</tt> class, for
  52    * example). Thus, iterating over the elements in a list is typically
  53    * preferable to indexing through it if the caller does not know the
  54    * implementation.<p>
  55    *
  56    * The <tt>List</tt> interface provides a special iterator, called a
  57    * <tt>ListIterator</tt>, that allows element insertion and replacement, and
  58    * bidirectional access in addition to the normal operations that the
  59    * <tt>Iterator</tt> interface provides.  A method is provided to obtain a
  60    * list iterator that starts at a specified position in the list.<p>
  61    *
  62    * The <tt>List</tt> interface provides two methods to search for a specified
  63    * object.  From a performance standpoint, these methods should be used with
  64    * caution.  In many implementations they will perform costly linear
  65    * searches.<p>
  66    *
  67    * The <tt>List</tt> interface provides two methods to efficiently insert and
  68    * remove multiple elements at an arbitrary point in the list.<p>
  69    *
  70    * Note: While it is permissible for lists to contain themselves as elements,
  71    * extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt>
  72    * methods are no longer well defined on such a list.
  73    *
  74    * <p>Some list implementations have restrictions on the elements that
  75    * they may contain.  For example, some implementations prohibit null elements,
  76    * and some have restrictions on the types of their elements.  Attempting to
  77    * add an ineligible element throws an unchecked exception, typically
  78    * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting
  79    * to query the presence of an ineligible element may throw an exception,
  80    * or it may simply return false; some implementations will exhibit the former
  81    * behavior and some will exhibit the latter.  More generally, attempting an
  82    * operation on an ineligible element whose completion would not result in
  83    * the insertion of an ineligible element into the list may throw an
  84    * exception or it may succeed, at the option of the implementation.
  85    * Such exceptions are marked as "optional" in the specification for this
  86    * interface.
  87    *
  88    * <p>This interface is a member of the
  89    * <a href="{@docRoot}/../technotes/guides/collections/index.html">
  90    * Java Collections Framework</a>.
  91    *
  92    * @param <E> the type of elements in this list
  93    *
  94    * @author  Josh Bloch
  95    * @author  Neal Gafter
  96    * @see Collection
  97    * @see Set
  98    * @see ArrayList
  99    * @see LinkedList
 100    * @see Vector
 101    * @see Arrays#asList(Object[])
 102    * @see Collections#nCopies(int, Object)
 103    * @see Collections#EMPTY_LIST
 104    * @see AbstractList
 105    * @see AbstractSequentialList
 106    * @since 1.2
 107    */
    public interface List<E> extends Collection<E> {
 110       // Query Operations
 111
 112       /**
 113        * Returns the number of elements in this list.  If this list contains
 114        * more than <tt>Integer.MAX_VALUE</tt> elements, returns
 115        * <tt>Integer.MAX_VALUE</tt>.
 116        *
 117        * @return the number of elements in this list
 118        */
 119       int size();
 120
 121       /**
 122        * Returns <tt>true</tt> if this list contains no elements.
 123        *
 124        * @return <tt>true</tt> if this list contains no elements
 125        */
 126       boolean isEmpty();
 127
 128       /**
 129        * Returns <tt>true</tt> if this list contains the specified element.
 130        * More formally, returns <tt>true</tt> if and only if this list contains
 131        * at least one element <tt>e</tt> such that
 132        * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
 133        *
 134        * @param o element whose presence in this list is to be tested
 135        * @return <tt>true</tt> if this list contains the specified element
 136        * @throws ClassCastException if the type of the specified element
 137        *         is incompatible with this list
 138        * (<a href="Collection.html#optional-restrictions">optional</a>)
 139        * @throws NullPointerException if the specified element is null and this
 140        *         list does not permit null elements
 141        * (<a href="Collection.html#optional-restrictions">optional</a>)
 142        */
 143       boolean contains(Object o);
 144
 145       /**
 146        * Returns an iterator over the elements in this list in proper sequence.
 147        *
 148        * @return an iterator over the elements in this list in proper sequence
 149        */
 150       Iterator<E> iterator();
 151
 152       /**
 153        * Returns an array containing all of the elements in this list in proper
 154        * sequence (from first to last element).
 155        *
 156        * <p>The returned array will be "safe" in that no references to it are
 157        * maintained by this list.  (In other words, this method must
 158        * allocate a new array even if this list is backed by an array).
 159        * The caller is thus free to modify the returned array.
 160        *
 161        * <p>This method acts as bridge between array-based and collection-based
 162        * APIs.
 163        *
 164        * @return an array containing all of the elements in this list in proper
 165        *         sequence
 166        * @see Arrays#asList(Object[])
 167        */
 168       Object[] toArray();
 169
 170       /**
 171        * Returns an array containing all of the elements in this list in
 172        * proper sequence (from first to last element); the runtime type of
 173        * the returned array is that of the specified array.  If the list fits
 174        * in the specified array, it is returned therein.  Otherwise, a new
 175        * array is allocated with the runtime type of the specified array and
 176        * the size of this list.
 177        *
 178        * <p>If the list fits in the specified array with room to spare (i.e.,
 179        * the array has more elements than the list), the element in the array
 180        * immediately following the end of the list is set to <tt>null</tt>.
 181        * (This is useful in determining the length of the list <i>only</i> if
 182        * the caller knows that the list does not contain any null elements.)
 183        *
 184        * <p>Like the {@link #toArray()} method, this method acts as bridge between
 185        * array-based and collection-based APIs.  Further, this method allows
 186        * precise control over the runtime type of the output array, and may,
 187        * under certain circumstances, be used to save allocation costs.
 188        *
 189        * <p>Suppose <tt>x</tt> is a list known to contain only strings.
 190        * The following code can be used to dump the list into a newly
 191        * allocated array of <tt>String</tt>:
 192        *
 193        * <pre>
 194        *     String[] y = x.toArray(new String[0]);</pre>
 195        *
 196        * Note that <tt>toArray(new Object[0])</tt> is identical in function to
 197        * <tt>toArray()</tt>.
 198        *
 199        * @param a the array into which the elements of this list are to
 200        *          be stored, if it is big enough; otherwise, a new array of the
 201        *          same runtime type is allocated for this purpose.
 202        * @return an array containing the elements of this list
 203        * @throws ArrayStoreException if the runtime type of the specified array
 204        *         is not a supertype of the runtime type of every element in
 205        *         this list
 206        * @throws NullPointerException if the specified array is null
 207        */
 208       <T> T[] toArray(T[] a);
 209
 210
 211       // Modification Operations
 212
 213       /**
 214        * Appends the specified element to the end of this list (optional
 215        * operation).
 216        *
 217        * <p>Lists that support this operation may place limitations on what
 218        * elements may be added to this list.  In particular, some
 219        * lists will refuse to add null elements, and others will impose
 220        * restrictions on the type of elements that may be added.  List
 221        * classes should clearly specify in their documentation any restrictions
 222        * on what elements may be added.
 223        *
 224        * @param e element to be appended to this list
 225        * @return <tt>true</tt> (as specified by {@link Collection#add})
 226        * @throws UnsupportedOperationException if the <tt>add</tt> operation
 227        *         is not supported by this list
 228        * @throws ClassCastException if the class of the specified element
 229        *         prevents it from being added to this list
 230        * @throws NullPointerException if the specified element is null and this
 231        *         list does not permit null elements
 232        * @throws IllegalArgumentException if some property of this element
 233        *         prevents it from being added to this list
 234        */
 235       boolean add(E e);
 236
 237       /**
 238        * Removes the first occurrence of the specified element from this list,
 239        * if it is present (optional operation).  If this list does not contain
 240        * the element, it is unchanged.  More formally, removes the element with
 241        * the lowest index <tt>i</tt> such that
 242        * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
 243        * (if such an element exists).  Returns <tt>true</tt> if this list
 244        * contained the specified element (or equivalently, if this list changed
 245        * as a result of the call).
 246        *
 247        * @param o element to be removed from this list, if present
 248        * @return <tt>true</tt> if this list contained the specified element
 249        * @throws ClassCastException if the type of the specified element
 250        *         is incompatible with this list
 251        * (<a href="Collection.html#optional-restrictions">optional</a>)
 252        * @throws NullPointerException if the specified element is null and this
 253        *         list does not permit null elements
 254        * (<a href="Collection.html#optional-restrictions">optional</a>)
 255        * @throws UnsupportedOperationException if the <tt>remove</tt> operation
 256        *         is not supported by this list
 257        */
 258       boolean remove(Object o);
 259
 260
 261       // Bulk Modification Operations
 262
 263       /**
 264        * Returns <tt>true</tt> if this list contains all of the elements of the
 265        * specified collection.
 266        *
 267        * @param  c collection to be checked for containment in this list
 268        * @return <tt>true</tt> if this list contains all of the elements of the
 269        *         specified collection
 270        * @throws ClassCastException if the types of one or more elements
 271        *         in the specified collection are incompatible with this
 272        *         list
 273        * (<a href="Collection.html#optional-restrictions">optional</a>)
 274        * @throws NullPointerException if the specified collection contains one
 275        *         or more null elements and this list does not permit null
 276        *         elements
 277        *         (<a href="Collection.html#optional-restrictions">optional</a>),
 278        *         or if the specified collection is null
 279        * @see #contains(Object)
 280        */
 281       boolean containsAll(Collection<?> c);
 282
 283       /**
 284        * Appends all of the elements in the specified collection to the end of
 285        * this list, in the order that they are returned by the specified
 286        * collection's iterator (optional operation).  The behavior of this
 287        * operation is undefined if the specified collection is modified while
 288        * the operation is in progress.  (Note that this will occur if the
 289        * specified collection is this list, and it's nonempty.)
 290        *
 291        * @param c collection containing elements to be added to this list
 292        * @return <tt>true</tt> if this list changed as a result of the call
 293        * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
 294        *         is not supported by this list
 295        * @throws ClassCastException if the class of an element of the specified
 296        *         collection prevents it from being added to this list
 297        * @throws NullPointerException if the specified collection contains one
 298        *         or more null elements and this list does not permit null
 299        *         elements, or if the specified collection is null
 300        * @throws IllegalArgumentException if some property of an element of the
 301        *         specified collection prevents it from being added to this list
 302        * @see #add(Object)
 303        */
 304       boolean addAll(Collection<? extends E> c);
 305
 306       /**
 307        * Inserts all of the elements in the specified collection into this
 308        * list at the specified position (optional operation).  Shifts the
 309        * element currently at that position (if any) and any subsequent
 310        * elements to the right (increases their indices).  The new elements
 311        * will appear in this list in the order that they are returned by the
 312        * specified collection's iterator.  The behavior of this operation is
 313        * undefined if the specified collection is modified while the
 314        * operation is in progress.  (Note that this will occur if the specified
 315        * collection is this list, and it's nonempty.)
 316        *
 317        * @param index index at which to insert the first element from the
 318        *              specified collection
 319        * @param c collection containing elements to be added to this list
 320        * @return <tt>true</tt> if this list changed as a result of the call
 321        * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
 322        *         is not supported by this list
 323        * @throws ClassCastException if the class of an element of the specified
 324        *         collection prevents it from being added to this list
 325        * @throws NullPointerException if the specified collection contains one
 326        *         or more null elements and this list does not permit null
 327        *         elements, or if the specified collection is null
 328        * @throws IllegalArgumentException if some property of an element of the
 329        *         specified collection prevents it from being added to this list
 330        * @throws IndexOutOfBoundsException if the index is out of range
 331        *         (<tt>index &lt; 0 || index &gt; size()</tt>)
 332        */
 333       boolean addAll(int index, Collection<? extends E> c);
 334
 335       /**
 336        * Removes from this list all of its elements that are contained in the
 337        * specified collection (optional operation).
 338        *
 339        * @param c collection containing elements to be removed from this list
 340        * @return <tt>true</tt> if this list changed as a result of the call
 341        * @throws UnsupportedOperationException if the <tt>removeAll</tt> operation
 342        *         is not supported by this list
 343        * @throws ClassCastException if the class of an element of this list
 344        *         is incompatible with the specified collection
 345        * (<a href="Collection.html#optional-restrictions">optional</a>)
 346        * @throws NullPointerException if this list contains a null element and the
 347        *         specified collection does not permit null elements
 348        *         (<a href="Collection.html#optional-restrictions">optional</a>),
 349        *         or if the specified collection is null
 350        * @see #remove(Object)
 351        * @see #contains(Object)
 352        */
 353       boolean removeAll(Collection<?> c);
 354
 355       /**
 356        * Retains only the elements in this list that are contained in the
 357        * specified collection (optional operation).  In other words, removes
 358        * from this list all of its elements that are not contained in the
 359        * specified collection.
 360        *
 361        * @param c collection containing elements to be retained in this list
 362        * @return <tt>true</tt> if this list changed as a result of the call
 363        * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation
 364        *         is not supported by this list
 365        * @throws ClassCastException if the class of an element of this list
 366        *         is incompatible with the specified collection
 367        * (<a href="Collection.html#optional-restrictions">optional</a>)
 368        * @throws NullPointerException if this list contains a null element and the
 369        *         specified collection does not permit null elements
 370        *         (<a href="Collection.html#optional-restrictions">optional</a>),
 371        *         or if the specified collection is null
 372        * @see #remove(Object)
 373        * @see #contains(Object)
 374        */
 375       boolean retainAll(Collection<?> c);
 376
 377       /**
 378        * Removes all of the elements from this list (optional operation).
 379        * The list will be empty after this call returns.
 380        *
 381        * @throws UnsupportedOperationException if the <tt>clear</tt> operation
 382        *         is not supported by this list
 383        */
 384       void clear();
 385
 386
 387       // Comparison and hashing
 388
 389       /**
 390        * Compares the specified object with this list for equality.  Returns
 391        * <tt>true</tt> if and only if the specified object is also a list, both
 392        * lists have the same size, and all corresponding pairs of elements in
 393        * the two lists are <i>equal</i>.  (Two elements <tt>e1</tt> and
 394        * <tt>e2</tt> are <i>equal</i> if <tt>(e1==null ? e2==null :
 395        * e1.equals(e2))</tt>.)  In other words, two lists are defined to be
 396        * equal if they contain the same elements in the same order.  This
 397        * definition ensures that the equals method works properly across
 398        * different implementations of the <tt>List</tt> interface.
 399        *
 400        * @param o the object to be compared for equality with this list
 401        * @return <tt>true</tt> if the specified object is equal to this list
 402        */
 403       boolean equals(Object o);
 404
 405       /**
 406        * Returns the hash code value for this list.  The hash code of a list
 407        * is defined to be the result of the following calculation:
 408        * <pre>
 409        *  int hashCode = 1;
 410        *  for (E e : list)
 411        *      hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
 412        * </pre>
 413        * This ensures that <tt>list1.equals(list2)</tt> implies that
 414        * <tt>list1.hashCode()==list2.hashCode()</tt> for any two lists,
 415        * <tt>list1</tt> and <tt>list2</tt>, as required by the general
 416        * contract of {@link Object#hashCode}.
 417        *
 418        * @return the hash code value for this list
 419        * @see Object#equals(Object)
 420        * @see #equals(Object)
 421        */
 422       int hashCode();
 423
 424
 425       // Positional Access Operations
 426
 427       /**
 428        * Returns the element at the specified position in this list.
 429        *
 430        * @param index index of the element to return
 431        * @return the element at the specified position in this list
 432        * @throws IndexOutOfBoundsException if the index is out of range
 433        *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
 434        */
 435       E get(int index);
 436
 437       /**
 438        * Replaces the element at the specified position in this list with the
 439        * specified element (optional operation).
 440        *
 441        * @param index index of the element to replace
 442        * @param element element to be stored at the specified position
 443        * @return the element previously at the specified position
 444        * @throws UnsupportedOperationException if the <tt>set</tt> operation
 445        *         is not supported by this list
 446        * @throws ClassCastException if the class of the specified element
 447        *         prevents it from being added to this list
 448        * @throws NullPointerException if the specified element is null and
 449        *         this list does not permit null elements
 450        * @throws IllegalArgumentException if some property of the specified
 451        *         element prevents it from being added to this list
 452        * @throws IndexOutOfBoundsException if the index is out of range
 453        *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
 454        */
 455       E set(int index, E element);
 456
 457       /**
 458        * Inserts the specified element at the specified position in this list
 459        * (optional operation).  Shifts the element currently at that position
 460        * (if any) and any subsequent elements to the right (adds one to their
 461        * indices).
 462        *
 463        * @param index index at which the specified element is to be inserted
 464        * @param element element to be inserted
 465        * @throws UnsupportedOperationException if the <tt>add</tt> operation
 466        *         is not supported by this list
 467        * @throws ClassCastException if the class of the specified element
 468        *         prevents it from being added to this list
 469        * @throws NullPointerException if the specified element is null and
 470        *         this list does not permit null elements
 471        * @throws IllegalArgumentException if some property of the specified
 472        *         element prevents it from being added to this list
 473        * @throws IndexOutOfBoundsException if the index is out of range
 474        *         (<tt>index &lt; 0 || index &gt; size()</tt>)
 475        */
 476       void add(int index, E element);
 477
 478       /**
 479        * Removes the element at the specified position in this list (optional
 480        * operation).  Shifts any subsequent elements to the left (subtracts one
 481        * from their indices).  Returns the element that was removed from the
 482        * list.
 483        *
 484        * @param index the index of the element to be removed
 485        * @return the element previously at the specified position
 486        * @throws UnsupportedOperationException if the <tt>remove</tt> operation
 487        *         is not supported by this list
 488        * @throws IndexOutOfBoundsException if the index is out of range
 489        *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
 490        */
 491       E remove(int index);
 492
 493
 494       // Search Operations
 495
 496       /**
 497        * Returns the index of the first occurrence of the specified element
 498        * in this list, or -1 if this list does not contain the element.
 499        * More formally, returns the lowest index <tt>i</tt> such that
 500        * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
 501        * or -1 if there is no such index.
 502        *
 503        * @param o element to search for
 504        * @return the index of the first occurrence of the specified element in
 505        *         this list, or -1 if this list does not contain the element
 506        * @throws ClassCastException if the type of the specified element
 507        *         is incompatible with this list
 508        *         (<a href="Collection.html#optional-restrictions">optional</a>)
 509        * @throws NullPointerException if the specified element is null and this
 510        *         list does not permit null elements
 511        *         (<a href="Collection.html#optional-restrictions">optional</a>)
 512        */
 513       int indexOf(Object o);
 514
 515       /**
 516        * Returns the index of the last occurrence of the specified element
 517        * in this list, or -1 if this list does not contain the element.
 518        * More formally, returns the highest index <tt>i</tt> such that
 519        * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
 520        * or -1 if there is no such index.
 521        *
 522        * @param o element to search for
 523        * @return the index of the last occurrence of the specified element in
 524        *         this list, or -1 if this list does not contain the element
 525        * @throws ClassCastException if the type of the specified element
 526        *         is incompatible with this list
 527        *         (<a href="Collection.html#optional-restrictions">optional</a>)
 528        * @throws NullPointerException if the specified element is null and this
 529        *         list does not permit null elements
 530        *         (<a href="Collection.html#optional-restrictions">optional</a>)
 531        */
 532       int lastIndexOf(Object o);
 533
 534
 535       // List Iterators
 536
 537       /**
 538        * Returns a list iterator over the elements in this list (in proper
 539        * sequence).
 540        *
 541        * @return a list iterator over the elements in this list (in proper
 542        *         sequence)
 543        */
 544       ListIterator<E> listIterator();
 545
 546       /**
 547        * Returns a list iterator over the elements in this list (in proper
 548        * sequence), starting at the specified position in the list.
 549        * The specified index indicates the first element that would be
 550        * returned by an initial call to {@link ListIterator#next next}.
 551        * An initial call to {@link ListIterator#previous previous} would
 552        * return the element with the specified index minus one.
 553        *
 554        * @param index index of the first element to be returned from the
 555        *        list iterator (by a call to {@link ListIterator#next next})
 556        * @return a list iterator over the elements in this list (in proper
 557        *         sequence), starting at the specified position in the list
 558        * @throws IndexOutOfBoundsException if the index is out of range
 559        *         ({@code index < 0 || index > size()})
 560        */
 561       ListIterator<E> listIterator(int index);
 562
 563       // View
 564
 565       /**
 566        * Returns a view of the portion of this list between the specified
 567        * <tt>fromIndex</tt>, inclusive, and <tt>toIndex</tt>, exclusive.  (If
 568        * <tt>fromIndex</tt> and <tt>toIndex</tt> are equal, the returned list is
 569        * empty.)  The returned list is backed by this list, so non-structural
 570        * changes in the returned list are reflected in this list, and vice-versa.
 571        * The returned list supports all of the optional list operations supported
 572        * by this list.<p>
 573        *
 574        * This method eliminates the need for explicit range operations (of
 575        * the sort that commonly exist for arrays).  Any operation that expects
 576        * a list can be used as a range operation by passing a subList view
 577        * instead of a whole list.  For example, the following idiom
 578        * removes a range of elements from a list:
 579        * <pre>
 580        *      list.subList(from, to).clear();
 581        * </pre>
 582        * Similar idioms may be constructed for <tt>indexOf</tt> and
 583        * <tt>lastIndexOf</tt>, and all of the algorithms in the
 584        * <tt>Collections</tt> class can be applied to a subList.<p>
 585        *
 586        * The semantics of the list returned by this method become undefined if
 587        * the backing list (i.e., this list) is <i>structurally modified</i> in
 588        * any way other than via the returned list.  (Structural modifications are
 589        * those that change the size of this list, or otherwise perturb it in such
 590        * a fashion that iterations in progress may yield incorrect results.)
 591        *
 592        * @param fromIndex low endpoint (inclusive) of the subList
 593        * @param toIndex high endpoint (exclusive) of the subList
 594        * @return a view of the specified range within this list
 595        * @throws IndexOutOfBoundsException for an illegal endpoint index value
 596        *         (<tt>fromIndex &lt; 0 || toIndex &gt; size ||
 597        *         fromIndex &gt; toIndex</tt>)
 598        */
 599       List<E> subList(int fromIndex, int toIndex);
 600   }

 Save This Page Home » openjdk-7 » java » util » [javadoc | source]
