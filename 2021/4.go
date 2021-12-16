package main

import (
	"fmt"
	"strings"
	"strconv"
)

func check(in [5][5]int) bool {
	for j := 0;j < 5;j ++ {
		if in[j][0] + in[j][1] + in[j][2] + in[j][3] + in[j][4] == -5 {
			return true
		}
		if in[0][j] + in[1][j] + in[2][j] + in[3][j] + in[4][j] == -5 {
			return true
		}
	}
	return false
}

func part1(n int) {
	var sequence string
	var mat [100][5][5]int
	fmt.Scanf("%s", &sequence)
	for i := 0;i < n;i ++ {
		for j := 0;j < 5;j ++ {
			for k := 0;k < 5;k ++ {
				var raw string
				fmt.Scanf("%s", &raw)
				if len(raw) < 1 {
					fmt.Scanf("%s", &raw)
				}
				mat[i][j][k], _ = strconv.Atoi(raw)
			}
		}
	}

	var commands = strings.Split(sequence, ",")
	var flag = false
	for i := 0; i < len(commands); i++ {
		var num, _ = strconv.Atoi(commands[i])
		for a := 0; a < n;a ++ {
			for j := 0;j < 5;j ++ {
				for k := 0;k < 5;k ++ {
					if mat[a][j][k] == num {
						mat[a][j][k] = -1
					}
				}
			}
		}
		for a := 0; a < n;a ++ {
			if check(mat[a]) {
				var ans = 0
				for j := 0;j < 5;j ++ {
					for k := 0;k < 5;k ++ {
						if mat[a][j][k] != -1 {
							ans += mat[a][j][k]
						}
					}
				}
				fmt.Println(ans * num)
				flag = true
				break
			}
		}
		if flag {
			break
		}
	}
}


func part2(n int) {
	var sequence string
	var mat [100][5][5]int
	var win[100] bool

	fmt.Scanf("%s", &sequence)
	for i := 0;i < n;i ++ {
		for j := 0;j < 5;j ++ {
			for k := 0;k < 5;k ++ {
				var raw string
				fmt.Scanf("%s", &raw)
				if len(raw) < 1 {
					fmt.Scanf("%s", &raw)
				}
				mat[i][j][k], _ = strconv.Atoi(raw)
			}
		}
	}

	var commands = strings.Split(sequence, ",")
	for i := 0; i < len(commands); i++ {
		var num, _ = strconv.Atoi(commands[i])
		for a := 0; a < n;a ++ {
			for j := 0;j < 5;j ++ {
				for k := 0;k < 5;k ++ {
					if mat[a][j][k] == num {
						mat[a][j][k] = -1
					}
				}
			}
		}
		for a := 0; a < n;a ++ {
			if !win[a] && check(mat[a]) {
				win[a] = true
				var ans = 0
				for j := 0;j < 5;j ++ {
					for k := 0;k < 5;k ++ {
						if mat[a][j][k] != -1 {
							ans += mat[a][j][k]
						}
					}
				}
				fmt.Println(ans * num)
			}
		}
	}
}

func main() {
	part2(100)
}
