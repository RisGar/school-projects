package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strings"
)

type rotReader struct {
	r io.Reader
}

func encode(b byte) byte {
	var start byte

	if 'a' <= b && b <= 'z' {
		start = 'a'
	} else if 'A' <= b && b <= 'Z' {
		start = 'A'
	} else {
		return b
	}

	return ((b - start + 13) % 26) + start
}

func (r *rotReader) Read(input []byte) (int, error) {
	size, err := r.r.Read(input)

	for i, byte := range input {
		input[i] = encode(byte)
	}

	return size, err
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter phrase: ")
	input, _ := reader.ReadString('\n')

	s := strings.NewReader(input)
	r := rotReader{s}
	io.Copy(os.Stdout, &r)
}