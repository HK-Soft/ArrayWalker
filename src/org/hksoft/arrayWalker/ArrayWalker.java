package org.hksoft.arrayWalker;

import java.awt.Point;

public class ArrayWalker<T> {

	private T[][] array;

	private Point position;

	private int height;

	private int width;

	public ArrayWalker(T[][] array) {
		assert array != null;
		assert array.length > 0;
		assert array[0].length > 0;
		this.array = array;
		this.height = array.length;
		this.width = array[0].length;
		this.position = new Point(0, 0);
	}

	@SuppressWarnings("unchecked")
	public ArrayWalker(int height, int width) {
		assert height > 0;
		assert width > 0;
		this.height = height;
		this.width = width;
		array = (T[][]) new Object[height][width];
		this.position = new Point(0, 0);
	}

	public ArrayWalker<T> goTo(int x, int y) {
		if (x < 0 || x >= array.length)
			throw new ArrayIndexOutOfBoundsException(x);

		if (y < 0 || y >= array[0].length)
			throw new ArrayIndexOutOfBoundsException(y);

		this.position = new Point(x, y);
		return this;
	}

	public ArrayWalker<T> goTo(int index) {
		if (index < 0 || index >= size())
			throw new ArrayIndexOutOfBoundsException(index);

		this.position = fromIndex(index);

		return this;
	}

	// Move to the next cell
	public ArrayWalker<T> next() {
		goTo(toIndex(position.x, position.y) + 1);
		return this;
	}

	// Move to the previous cell
	public ArrayWalker<T> previous() {
		goTo(toIndex(position.x, position.y) - 1);
		return this;
	}

	// Move to the cell in the right
	public ArrayWalker<T> right() {
		goTo(position.x, position.y + 1);
		return this;
	}

	// Move to the cell in the left
	public ArrayWalker<T> left() {
		goTo(position.x, position.y - 1);
		return this;
	}

	// Move to the cell in the top
	public ArrayWalker<T> top() {
		goTo(position.x - 1, position.y);
		return this;
	}

	// Move to the cell in the bottom
	public ArrayWalker<T> bottom() {
		goTo(position.x + 1, position.y);
		return this;
	}

	public T getValue() {
		return array[position.x][position.y];
	}

	public void setValue(T value) {
		array[position.x][position.y] = value;
	}

	public int size() {
		return this.width * this.height;
	}

	public Point getPosition() {
		// create a defensive copy to prevent direct access to the position attribute
		return new Point(position.x, position.y);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	private int toIndex(int x, int y) {
		assert x >= 0 && x < height;
		assert y >= 0 && y < width;
		return (width * x) + y;
	}

	private Point fromIndex(int index) {
		assert index >= 0 && index < size();
		return new Point(index / width, index % width);
	}

}
