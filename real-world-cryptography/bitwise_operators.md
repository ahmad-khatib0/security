
## Some Bitwise operators in programming languages: 
1. AND (&)
2. OR (|)
3. XOR (^)
4. NOT (~)
5. Arithmetic Right SHIFT (>>)
6. Logical Right SHIFT (>>>)
7. Left SHIFT (<<)

Note that when performing a bitwise operation, it is common to represent the binary using a 
fixed shape of binary which is commonly a byte (8 bits make one byte). 
The 25 decimal converted to binary which gives us 11001 can be made to fit 8 bits shape simply by 
adding 0s at the back until it's 8-digits:  E.g., 11001 becomes 0001 1001.

A set of switches is a binary number, remember we are dealing with bitwise. For instance, if you're 
given 15 and you're asked to find it's bitwise, convert it to binary and the result is our switch.

```javascript
let x = 6 & 15 
```
# 6 is a decimal, likewise 15.

## Step 1: Convert them to binary so that: 
6 = 110
15 = 1111

## Step 2: Make each of them the same shape 
6 = 0000 0110
15 = 0000 1111

Now we can perform AND bitwise operator on the two switches since they're of the same shape.

# The rule for AND bitwise operator is:
   - Keep the same element
   - Choose OFF over ON
   
# Using that rule, we will have:
    6 = 0000 0110
    15 = 0000 1111

    (6 & 15) = 0000 0110

You can safely remove all 0s that comes before the first 1, so that our final answer is: 110. 
So therefore (6 & 15) is 6.

That's the simple logic behind the operation. Remember, you always have to convert any given 
number to binary and ensure the two numbers are in the same shap

```python
def bitwise_and(x, y):
  return x & y

print(bitwise_and(6, 15))
```

## 2. Bitwise OR Operator ("|")
The rule for OR is: 
- Keep the same
- Choose ON over OFF

Using the same switches (6, 15). To find (6 | 15), we also do:

conversion and having equal shape

6 = 0000 0110
15 = 0000 1111

result

(6 | 15) = 0000 1111

Finally result for (6 | 15) is 1111, converting to decimal, we have **15**.

```python
def bitwise_or(x, y):
  return x | y

print(bitwise_or(6, 15)) 
```

## 3. Bitwise XOR Operator ("^")

XOR is otherwise known as eXclusive OR. And it follows the same pattern as the OR operation. 

But the difference is you don't keep the same element, but you choose OFF if they are the same. 
Here is what I mean using the rule: 
- For the same element, choose OFF
- Choose ON over OFF.

To demonstrate that, let's do (6 ^ 15)

Remember:

6 = 0000 0110
15 = 0000 1111

Ignore the same first 0s.

(6 ^ 15) = 1001

In decimal, (6 ^ 15) is 9.


## 4. Bitwise NOT Operator ("~")

The bitwise NOT Operator is quite different from the first 3 we've explained. 

Bitwise NOT Operator doesn't compare, you don't have 2 sets of switches here but one.

The rule is simple: 

- If it's a binary, Flip the element, change ON to OFF, and vice versa. Meaning 0 becomes 1 and vice versa.
- If it's a positive decimal, add 1 to it and make it negative
- If it's a negative decimal, make it positive and subtract 1 from it

Let's use the same figures as an example.

(~ 6) becomes -7
(~ 15) becomes -16.
(~ -6) becomes 5
(~ -15) becomes 14

Here's the binary operation happening behind the scene using the rule.

6 = 0000 0110

If you flip, you'll have 1111 1001

So ~6 in bit level is 1111 1001

# Now here is the confusion:

But decimal -7 is not the same as binary `1111 10001`. Yeah, that's the surprising behavior of 
the NOT Operator.
For the negative or positive sign that's changing, the reason is simply because a number has its 
own sign, flipping the number also flips the sign.

For example, every natural number has a positive sign which is generally not written. Flipping 
the number will make the sign change.

That's why ~6 becomes -7 and ~-6 becomes 5


## 5. Bitwise Right SHIFT (">>") 
Right shifting is just exactly as it is called, you simply move a number by the number of 
times you're given or need it to shift.

# But before explaining, **here is the rule**.
- Divide the given natural number by 2 and round it down.
- If it's a binary, move each digital one by one to the right
- When shifting, you'll lose a digital, replace it with 0

For example:

If you're to right 6 by 1, that is to move it forward by 1 or 6 >> 1

To get your answer in decimal, simply divide by 2 and your answer is 3.

6 >> 2 becomes 1.

explanation:

6 >> 2 is 6 ÷ (2×2) which is 6 ÷ 4

You'll get 1 remainder 2, throw the remainder out of the window.

8 >>> 3 is 8 ÷ (2×3) which is 8/6 = 1

Question: What if you want to right shift 6 in 3 times (6 >> 3)

Your quick understanding is 6 ÷ (2*2*2) which is 6÷9…. That's 0 remainders 3.

Round it down to 0.

If the number of times you're right shifting is bigger than the number you're shifting, the answer is 0.

For binary.

110 >> 1 becomes 011 or simply 11

converting 11 to decimal gives you 3.

110 >> 2 becomes 1.

So either binary way or decimal way, you'll get the same answer.

