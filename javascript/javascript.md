# JavaScript

## Document Object Model (DOM)

- `getElementById`
- `innerHTML`
- `textContent`
- `setAttribute`
- `getAttribute`
- `element.style.left = "20px";`
- `element.style.backgroundColor = "red";` make sure JS uses camel case for decorations.
- `createElement`
- `appendChild`
- `insertBefore`

## `use strict`

- Including `"use strict"` at the top of file forces to run JS file in strict mode.
- Having `"use strict"` converts mistakes into noticeable errors.
- secures JavaScript

## `var` vs `let`

## `window.onload` vs `window.addEventListener`

## Null Check in JS

If the return value of `func.method()` is null, `a = ""`.

```javascript
var a = func.method() ?? "";
```

## Encapsulation in JavaScript


## filter method

```javascript
const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];

const result = words.filter((word) => word.length > 6); // only select words which length is greater than 6.

console.log(result);
// expected output: Array ["exuberant", "destruction", "present"]
```

The original array doesn't change.