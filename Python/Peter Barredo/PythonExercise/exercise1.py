number = 23
guess = int(input("Type a number: "))
if guess == number:
	print('Yeah')
elif guess < number:
	print('Its a liittle bit small')
else:
	print('wrong, a little bit bigger')
print('done')