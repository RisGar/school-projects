const encode = (text: string, rows: number = 3, offset: number = 0): string => {
  let strings: Array<string> = []

  text.split("").forEach((e: string, i: number) => {
    let pos: number = (i + offset) % (rows * 2 - 2)
    if (pos >= rows) pos = rows * 2 - 2 - pos
    strings[pos] ? (strings[pos] += e) : (strings[pos] = e)
    console.log(e + ", " + pos)
  })
  return strings.join("").replace(/ /g, "•")
}

const decode = (text: string, rows: number = 3, offset: number = 0): string => {
  let strings: Array<string> = []

  text.split("").forEach((e: string, i: number) => {
    let pos: number = (i + offset) % (rows * 2 - 2)
    if (pos >= rows) pos = rows * 2 - 2 - pos
    strings[pos] ? (strings[pos] += e) : (strings[pos] = e)
    console.log(e + ", " + pos)
  })
  return strings.join("").replace(/ /g, "•")
}

console.log(encode("Test 123", 7, 3))
