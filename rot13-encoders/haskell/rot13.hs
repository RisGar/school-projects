import Data.Char ( ord, chr )
import System.IO ( stdout, hFlush )
import Data.Bool ( bool )
import Control.Monad (liftM2)
import qualified Data.Functor

-- encode ':: Char -> Char
-- encode' char
--   | 'a' <= char && char <= 'z' = chr . (ord 'a' +) . flip mod 26 . (13 +) . subtract (ord 'a') . ord
--   | 'A' <= char && char <= 'Z' = chr . (ord 'A' +) . flip mod 26 . (13 +) . subtract (ord 'A') . ord
--   | otherwise = char

encode :: Char -> Char
encode char
  | 'a' <= char && char <= 'z' = chr (mod (ord char - (ord 'a' + 13)) 26 + ord 'a')
  | 'A' <= char && char <= 'Z' = chr (mod (ord char - (ord 'A' + 13)) 26 + ord 'A')
  | otherwise = char


main :: IO ()
main = putStr "Enter phrase: "  >> hFlush stdout >> getLine >>= putStrLn . map encode

