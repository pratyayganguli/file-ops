package com.project.fileops.util.generators;

/**
 * created on: 08 15 2023
 * 11:17 am
 */
public interface Generator<T> {
    T generate(int length);
}
