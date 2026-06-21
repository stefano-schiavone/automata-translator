package main

func add(a int, b int) int {
	return a + b
}

func swap(a int, b int) (int, int) {
	return b, a
}

func main() {
	var x int = 10
	y := 3
	z := add(x, y)
	fmt.Println("Sum:", z)

	p, q := swap(x, y)
	fmt.Println("After swap:", p, q)

	if z > 10 {
		fmt.Println("big")
	} else {
		fmt.Println("small")
	}

	for i := 0; i < 3; i++ {
		fmt.Println(i)
	}
}
