package main

import (
	"fmt"
	"io"
)

func part1() {
	var i int
	var j = -1
	var ans = 0
	for {
		_, err := fmt.Scanf("%d", &i)
		if err == io.EOF {
			break
		}
		if j != -1 && i > j {
			ans ++
		}
		j = i
	}
	fmt.Println(ans)
}

func part2() {
	var a,b,c,d int = -1, -1, -1, -1
	var ans = 0
	for {
		_, err := fmt.Scanf("%d", &d)
		if err == io.EOF {
			break
		}
		if a != -1 && b != -1 && c != -1 && d > a {
			ans ++
		}
		c, b, a = d, c, b
	}
	fmt.Println(ans)
}

func main() {
	part2()
}
