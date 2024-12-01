# %% [markdown]
# ## „Gartenzaun“-Transposition
# 
# Beim Gartenzaun-Transpositionsverfahren wird der Klartext auf verschiedene Zeilen aufgeteilt und schließlich zusammengefügt. Hierbei werden im "Zickzack"-Muster die Zeichen des Klartextes in die Zeilen verteilt. Aus dem Klartext "Hello, World!" wird so:
# 
# ```
# H———o———o———!
# —e—l—,—W—r—d—
# ——l——— ———l——
# 
# Hoo!el,Wrdl l
# ```
# 
# Hierbei kann auch eine Verschiebung also ein "Offset" gesetzt werden. Hier zum Beispiel der Offset 2:
# 
# ```
#  ———l——— ———l——
# — —e—l—,—W—r—d—
# ——H———o———o———!
# 
# l lel,WrdHoo!
# ```

# %%
### Verschlüsseln ###

def encrypt(text: str, rows: int = 3, offset: int = 0) -> str:
  strings: list[str] = [''] * rows

  ### Einordnen des Klartextes in die Reihen des "Gartenzauns"
  for i, e in enumerate(text, start = 0):
    pos: int = (i + offset) % (rows * 2 - 2)
    if (pos >= rows): pos = rows * 2 - 2 - pos
    strings[pos] += e

  return ''.join(strings)

### Entschlüsseln ###

def decrypt(text: str, rows: int = 3, offset: int = 0) -> str:

  ### Längen der Reihen bestimmen
  lStrings: list[str] = [''] * rows
  for i, e in enumerate(text, start = 0):
    pos: int = (i + offset) % (rows * 2 - 2)
    if (pos >= rows): pos = rows * 2 - 2 - pos
    lStrings[pos] += e

  ### Seperieren des Geheimstextes in die in der Verschlüsselung verwendeten Reihen
  strings: list[str] = [''] * rows
  s = list(text)
  for i, e in enumerate(lStrings, start = 0):
    for j in range(len(e)):
      strings[i] += s[0]
      s.pop(0)

  ### Umgekehrtes Einorden der Verschlüsselung / Umsortieren der Reihen zum Klartext
  res = ''
  for i in range(len(text)):
    pos: int = (i + offset) % (rows * 2 - 2)
    if (pos >= rows): pos = rows * 2 - 2 - pos
    res += strings[pos][0]
    strings[pos] = strings[pos][1:]

  return res


if __name__ == "__main__":
  print(encrypt('Hello, World!', 3, 2)) # Klartext, Reihen, Verschiebung
  print(decrypt('l lel,WrdHoo!', 3, 2)) # Geheimtext, Reihen, Verschiebung

  ### Eingabe
  klartext = "Geheimer Text!"
  reihen = 3
  verschiebung = 2

  geheimtext = encrypt(klartext, reihen, verschiebung)
  print(geheimtext)
  print(decrypt(geheimtext, reihen, verschiebung))



