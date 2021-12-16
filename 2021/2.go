package main

import (
	"fmt"
	"io"
)

func part1() {
	var instruction string
	var step int
	var position_x, position_y = 0, 0
	for {
		_, err := fmt.Scanf("%s %d", &instruction, &step)
		if err == io.EOF {
			break
		}
		switch instruction {
			case "forward": position_x += step
			case "down": position_y += step
			case "up": position_y -= step
		}
	}
	fmt.Println(position_x * position_y)
}

func part2() {
	var instruction string
	var step int
	var position_x, position_y, aim = 0, 0, 0
	for {
		_, err := fmt.Scanf("%s %d", &instruction, &step)
		if err == io.EOF {
			break
		}
		switch instruction {
		  case "forward":
			position_x += step
			position_y += step * aim
			case "down": aim += step
			case "up": aim -= step
		}
	}
	fmt.Println(position_x * position_y)
}

func main() {
	part2()
}
