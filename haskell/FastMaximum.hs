{-# OPTIONS_GHC -Wall #-}

import Data.Ix

-- Problem:
-- https://www.hackerrank.com/contests/coding-gym-brianza-march-2024/challenges/fast-maximum

data Gen i a = Gen {bounds :: (i, i), runGen :: i -> a}

-- | Get the value at a given index.
(!) :: Ix i => Gen i a -> i -> a
(!) g i
  | inRange b i = runGen g i
  | otherwise = undefined
  where
    b = bounds g

-- | Make the generator @Foldable@.
instance Ix i => Foldable (Gen i) where
  foldr f z g =
    foldr (f . (g !)) z
      . range
      . bounds
      $ g

-- | Make the generator @Functor@.
instance Ix i => Functor (Gen i) where
  fmap f (Gen b gen) = Gen b (f . gen)

-- | Make the generator @Show@.
instance (Ix i, Show a) => Show (Gen i a) where
  show = ('[' :) . foldr ((++) . (' ' :) . show) " ]"

-- | Construct a "hill generator", i.e. a generator collection for a collection
-- of integers with a hill-like shape.
--
-- The values will increase up to a certain value and decrease from there on:
--
-- > hill 10 8 1
-- > [ 0 1 2 3 4 5 6 7 1 0 ]
--
-- > hill 10 5 1
-- > [ 0 1 2 3 4 4 3 2 1 0 ]
hill :: (Num a, Ix i, Integral i) => i -> i -> a -> Gen i a
hill len incTo step = Gen (0, len - 1) gen
  where
    ib = (0, incTo - 1)
    db = (incTo, len - 1)
    gen j
      | inRange ib j = step * fromIntegral (index ib j)
      | inRange db j = step * fromIntegral (rangeSize db - index db j - 1)
      | otherwise = undefined

-- Write your solution here
findPeak :: (Ix i, Integral i, Ord a) => Gen i a -> a
-- findPeak = ...

-- | Read an integer from stdin.
readInt :: IO Int
readInt = readLn

-- | Read the generator parameters from the standard input and evaluate the peak
-- of the hill.
main :: IO ()
main = do
  len   <- readInt
  incTo <- readInt
  step  <- readInt
  print . findPeak $ hill len incTo step
