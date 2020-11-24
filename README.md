# Coding challenge interval merge

## Introduction

The task is to merge a list of intervals. Overlapping intervals must be merged, separate kept separate. See complete documentation [online](https://docs.google.com/document/d/1FS272sy-boGQ49TBFKirIbn5YLasZi1XcyAq5NZ2uBI) or [local as PDF](./Coding_Task_2.pdf).

## Expectations

Following things were not described and are expected:
- Providing an empty list, returns an empty list.
- NULL as input raises an IllegalArgumentException.

## Explanations

### Approach

The input interval list is sorted by the intervals start. Having this simply the intervals can be processed one after the other and checking for gaps when taking the next interval.

### Performance

The time complexity of the interval merge is because of the sorting O(n*log(n)). The sorting is more complex than the merging of the intervals having the time complexity O(n).


### Memory consumption

Being x the memory consumption of one interval, n the size of the input interval and m the size of the result interval: The overall memory consumption is ( n + m ) * x.

### Robustness

As standard java.util classes are used the execution scales ideally.

## Usage

### Building

`./gradlew build`

### Execution

`./gradlew run`

## Time tracking

- 2020-11-24 19:15 - 21:35
