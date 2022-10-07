# Part4

## What does the semicolon indicate in a Java program?

> It indicates the end of a statement

-----

## What does the *main* method do? When do you want a class to have a *main* method?

> The *main* method indicates the entry point to the application. You only want a class to have a *main* method you want the class to be the entry point

-----

## How do static fields and methods work? Why do you need static fields or methods?

> Static fields and methods can be accessed without an instance of a class and are good for storing information that is universal to that class.

-----

## What access type can a method have in addition to "*public*"? When do you use ach type?

> There are 4 access types, public, private, default, and protected.
> Public is used when you want the method to be accessible from anywhere in the program.
> Private is used when you only want access to the method from within the same class.
> Default is used when you want the method to be accessible from within the same package.
> Protected is used when you want the method accessible from withing the same package or the subclasses in different packages.

-----

## What is "*String[] args*"? What does it do?

> *String[] args* is the argument supplied to the program when it gets ran from the command line. You can access the arguments that are givin within the array elements.

-----

## Why does it take "*System.out.println*" to print a line? Explain the relationship among *System*, *out* and *println*

> To print a line in Java, it is required to have "System.out.println" because if we didn't use the method "println" we would just have a string of text within our java file and that would cause an error. Its also required to have the "System.out." before the "println" because by default println isn't included within the scope. System is a final class, out is a class within the final class, and println is a method of the out class.