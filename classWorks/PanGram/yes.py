def multiply(x, y):
    for i in range(y):
        print(i * x, end=" ")
    print()

def times_table(x):
    for i in range(x):
        multiply(i, x)
        print()

times_table(5)
