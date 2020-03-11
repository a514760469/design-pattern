---
layout: pattern
title: Iterator
folder: iterator
permalink: /patterns/iterator/
categories: Behavioral
tags:
 - Gang of Four
---

## Also known as
Cursor

## Intent
Provide a way to access the elements of an aggregate object
sequentially without exposing its underlying representation.
提供一种方法来按顺序访问聚合对象的元素，而无需公开其底层表示。

## Class diagram
![alt text](./etc/iterator_1.png "Iterator")

## Applicability
Use the Iterator pattern

* to access an aggregate object's contents without exposing its internal representation
访问聚合对象的内容而不暴露其内部表示形式
* to support multiple traversals of aggregate objects
支持聚合对象的多次遍历
* to provide a uniform interface for traversing different aggregate structures
为跨越不同的聚合结构提供统一的接口

## Real world examples

* [java.util.Iterator](http://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)
* [java.util.Enumeration](http://docs.oracle.com/javase/8/docs/api/java/util/Enumeration.html)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
