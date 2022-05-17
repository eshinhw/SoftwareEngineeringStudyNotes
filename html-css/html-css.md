# HyperText markup Language (HTML)

HTML is used to structure content on a web page (images, text, forms etc). We use HTML tags to structure contents.

`tagName + tab` populates HTML tag directly.

## Basic Tags of HTML: HyperText Markup Language

- `<p>`: paragraph
- `<strong>`: make the text bold indicating that it's important
- `<small>`: make the text smaller
- `<em>`: make the text italic
- `<h1>` ~ `<h6>`: headings
- `<img>`
- `<ul>`: unordered list is a wrapper for `<li>` tags with symbols.
- `<ol>`: ordered list is a wrapper for `<li>` tags with numbers.
- `<div>`: used to divide contents into different sections or group together relevant contents which belong together. `<div>` has no visual difference but it comes handy when we work with CSS.
- `<span>`: used to add CSS or JS hooks to text of HTML.
- `<br>`: linebreak (no closing tag needed since no content inside it)
- `<hr>`: horizontal ruler (Equivalent to `<hr />`)

## HTML Attributes

- `<img src="image_path", alt="text representation of image for accessibility">`
- `<a href="">`: href is hyperlink reference
- `<blockquote cite="source">`: used for quoting
- `<p style="">`: style attributes in `<p>` can be used for text styling.

## HTML Forms

```html
<form action="">
    <label for="username">enter username: </label>
    <input type="text" id="username"> 
    <br><br>
    <label for="email"> enter email: </label>
    <input type="email" id="email"> 
    <br><br>
    <label for="password"> enter password: </label>
    <input type="password" id="password">

    <input type="radio" name="gender" value="Male"> Male <br>
    <input type="radio" name="gender" value="Female"> Female <br>
    <input type="radio" name="gender" value="Other"> Other <br>
</form>
```

- `id` attribute identifies a specific tag which can be used in CSS and JS.
- `name` attribute identifies a tag but it has another purpose which is service side processing. It'a always good practice to add `name` attribute same as `id`.
- `name` is also important for grouping for `radio` type.
- `required`: input must be provided for validataion
- `placeholder`: is like a `hint` in Android
- `<select> + <option>`

```html
<label for="">Security Question:</label>
    <select name="question" id="question">
        <option value="q1">What colour are your favorite pair of socks?</option>
        <option value="q2">If you could be a vegetable, what it be?</option>
        <option value="q3">What is your favorite movie?</option>
    </select>
```

# Cascading Style Sheets (CSS)

![picture 1](../images/b91592b8e2486410dba91357e3de48ec701fe07dab457446981211358d0ba45d.png)  

CSS works alongside with HTML, and are used to style web pages to make them look better by changing colours, position, effects, font sizes etc.

## CSS Decorations

- `color`
- `background-color`
- `text-decoration`
- `font-family`
- `text-align`
- `line-height`
- `letter-spacing`
- `column-count`
- `column-gap`
- `border-width`
- `border-style`

## CSS Classes and Selectors

Here are some HTML tags.

```html
<p class="intro"> Hello World! </p>
<div class="first"> First Div </div>
<p id="uniqueID"> Paragraph for UniqueID </p>
<a href="www.google.com"> Click here! </a>
<div class="second"><p> Second Div </p></div>
```

We can modify the contents of HTML tags using CSS decorations.

```css
p {
    /* decorations for all <p> tags */
}

.intro {
    /* decorations for all tags which class name is "intro" */
}

div p {
    /* decorations for <p> tags which parent is <div> */
}

#uniqueID {
    /* decorations for all tags which ID are "uniqueID" */
}

p.error {
    /* decorations for all <p> tags which class name is "error" */
}

p.error.success {
    /* decorations for all <p> tags which class name is "error" and "success" */
}

div p a {
    /* decorations for all <a> tags inside <p> and <div> in order (<p> must be inside <div>) */
}

div .error {
    /* decorations for any class of "error" inside <div> */
}
```

## Attribute Selectors

```css
a[href] {
    /* decorations for all <a> tags which have href attribute */
}

a[href="google.com"] {
    /* decorations for all <a> tags which have href attribute with "google.com" */
}

a[href*="google"] {
    /* decorations for all <a> tags which href attribute contains "google" */
}

a[href$=".com"] {
    /* decorations for all <a> tags which href attribute ends with ".com" */
}
```

## The Cascade - Inheritance and Specification

CSS runs from the top to the bottom. However, selectors with more specific selections can't be overriden.

```html
<div><p>Hello World!</p></div>
```

```css
div {
    color: red;
    border: 1px solid grey;
    margin: 40px;
    font-weight: bold;
}

p {
    border:inherit;
    margin:inherit;
    /* crimson color is more specific decoration -> overrides parent color decoration */
    color: crimson; 
}
```


