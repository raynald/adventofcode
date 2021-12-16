package main

import (
	"fmt"
	"io"
)

func part1(n int) {
	var binary string
	var count = 0
	var v [12]int
	for {
		_, err := fmt.Scanf("%s", &binary)
		if err == io.EOF {
			break
		}
		count ++
		for i := 0; i < n;i ++ {
			if binary[i] == '1' {
				v[i] ++
			}
		}
	}
	var ans = 0
	for i := 0;i < n;i ++ {
		ans *= 2
		if v[i] > count - v[i] {
			ans ++
		}
	}
	fmt.Println(ans * (1 << n - 1 - ans))
}

func part2(n int) {
	var binary string
	var count = 0
	var store [1000]string
	var v0, v1 [1000]bool

	for {
		_, err := fmt.Scanf("%s", &binary)
		if err == io.EOF {
			break
		}
		store[count] = binary
		count ++
	}
	var cut_1, cut_0 = 0, 0
	for i := 0;i < n;i ++ {
		var local_num_1 = 0
		var local_1 = 0
		var local_num_0 = 0
		var local_0 = 0
		for j := 0;j < count;j ++ {
			if v1[j] == false {
				local_num_1 ++
				if store[j][i] == '1' {
					local_1 ++
				}
			}
			if v0[j] == false {
				local_num_0 ++
				if store[j][i] == '0' {
					local_0 ++
				}
			}
		}
		var pivot1, pivot0 byte = '0', '0'
		if 2 * local_1 < local_num_1 {
			pivot1 = '1'
		}
		if 2 * local_0 <= local_num_0 {
			pivot0 = '1'
		}
		for j := 0;j < count;j ++ {
			if !v1[j] && store[j][i] == pivot1 && cut_1 < count - 1 {
				v1[j] = true
				cut_1 ++
			}
			if !v0[j] && store[j][i] == pivot0 && cut_0 < count - 1 {
				v0[j] = true
				cut_0 ++
			}
		}
	}
	var ans_1, ans_0 = 0, 0
	for j := 0;j < count;j ++ {
		if !v1[j] {
			fmt.Println(store[j])
			for k := 0;k < n;k ++ {
				ans_1 *= 2
				if (store[j][k] == '1') {
					ans_1 ++
				}
			}
		}
		if !v0[j] {
			fmt.Println(store[j])
			for k := 0;k < n;k ++ {
				ans_0 *= 2
				if (store[j][k] == '1') {
					ans_0 ++
				}
			}
		}
	}
	fmt.Println(ans_1 * ans_0)
}

func main() {
	part2(12)
}
