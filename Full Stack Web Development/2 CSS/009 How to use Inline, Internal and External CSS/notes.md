# 009 How to use Inline, Internal and External CSS

**Inline** - CSS that is applied directly to the element and is defined inside of the tag

**Internal** - CSS that is defined in the head of the HTML file and is written like a normal CSS file
    **`<style>`** - Used to define internal stylesheets

**External** - CSS that is defined in a separate file
    **`<link rel="" href="">`** - Links external files to the page
        **`rel=""`** - Defines the relationship of the file to the page ("stylesheet" for CSS documents)
        **`href=""`** - Defines the location of the external file

In *Internal* or *External* style sheets, you can define the style of an element by stating the element then `{ }` and put hte style in there:

```
h1 {
    color: red;
}
```

