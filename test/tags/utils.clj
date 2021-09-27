(ns tags.utils)

(def img-url "https://www.foo.com")
(def bar-url "https://www.bar.com")
(def foobar-url "https://www.foobar.com")
(def img-tag (str "<img src='" img-url "'/>"))
(def a-tag (str "<a href='" bar-url "'></a>"))
(def div-tag (str "<div><a href='" foobar-url "'></a></div>"))

(def example (str "<!DOCTYPE html>
  <html lang=\"en\">
<head>
  <title>Title of the document</title>
</head>
<body>
<h1>This is a heading</h1>
<p>This is a paragraph.</p>"
                  img-tag
                  a-tag
                  div-tag
                  "</body>"
                  "</html>"))
