# Roman to Int Converter

This program is able to convert Roman numerals into Arabic numerals.  
There are two functions, `romanToIntSub` and `romanToInt`. These two functions can both derive correct answers for official forms of Roman numerals.  
However, I incorrectly understood the rules of Roman numerals initially. So I thought that forms like `IXC`(91) should also be considered, and recursions were used in `romanToIntSub`.  
Then, `vijayshankar90` in [this post](https://leetcode.com/problems/roman-to-integer/discuss/255219/C-loop-and-switch-cased) gave me a [link](https://www.knowtheromans.co.uk/Categories/SubCatagories/RomanNumerals/) describing the rules of Roman numerals. The correct form of 91 should be `XCI` instead.  
Therefore, `romanToInt`, which only use for loops, is sufficient to get correct answers. After all, I learned something I did not know before, thanks `vijayshankar90` on LeetCode!
