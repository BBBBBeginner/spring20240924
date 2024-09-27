<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%-- element 명 tab --%>
<h1></h1>
<p></p>
<div></div>


<%-- p+div --%>
<p></p>
<div></div>


<%--h1 + p--%>
<h1></h1>
<p></p>


<%--h1+h2+h3--%>
<h1></h1>
<h2></h2>
<h3></h3>


<%-- > --%>
<div>
    <p></p>
</div>


<%-- h1>span --%>
<h1>
    <span></span>
</h1>
<h1>
    <span></span>
</h1>


<%--#--%>
<%--h1#head1--%>
<h1 id="head1"></h1>

<%--h1#head2>p#para1--%>
<h1 id="head2">
    <p id="para1"></p>
</h1>

<%--h1#head3+h2#sub1--%>
<h1 id="head3"></h1>
<h2 id="sub1"></h2>

<%--div#box1--%>
<div id="box1"></div>


<%--.--%>
<%--h1.head--%>
<h1 class="head"></h1>

<%--h1.head.note--%>
<h1 class="head note"></h1>

<%--h1#head01.error.note--%>
<h1 id="head01" class="error note"></h1>


<%--[]--%>
<%--h1[title]--%>
<h1 title=""></h1>

<%--h1[title="my head"]--%>
<h1 title="my head"></h1>

<%--input[value="hello"][name="message"][title="input"]--%>
<input type="text" value="hello" name="message" title="input">


<%--*--%>
<%--p*3--%>
<p></p>
<p></p>
<p></p>
<%--tr*2--%>
<tr></tr>
<tr></tr>

<%--table>tr*3>td*4--%>
<table>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>


<%--^--%>
<%--div>h1>span+p--%>
<%-- + : 안에--%>
<div>
    <h1>
        <span></span>
        <p></p>
    </h1>
</div>
<%-- ^: 옆에 --%>

<div>
    <h1>
        <span></span>
    </h1>
    <p></p>
</div>

<%--table>thead>tr>th*4^^tbody>tr*3>td*4--%>
<table>
    <thead>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
</table>


<%--lorem--%>
Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto culpa ea enim facere hic in perferendis? Aspernatur
earum et id pariatur
quasi quibusdam reprehenderit tenetur! Autem consequuntur cumque dolorem nulla!

<%--lorem3--%> //단어 3개만, 단어 개수 조정 가능
Lorem ipsum dolor.

<%--table>thead>tr>th*4>lorem1^^^tbody>tr*3>th*4>lorem1--%>
<table>
    <thead>
    <tr>
        <th>Lorem.</th>
        <th>Asperiores.</th>
        <th>Voluptate.</th>
        <th>Ab.</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>Lorem.</th>
        <th>Odio.</th>
        <th>Rem.</th>
        <th>Similique.</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Corporis.</th>
        <th>Voluptas!</th>
        <th>Eius?</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Excepturi?</th>
        <th>Facere?</th>
        <th>Beatae?</th>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <th>Lorem.</th>
        <th>Eligendi.</th>
        <th>Ad.</th>
        <th>Facilis.</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Iste.</th>
        <th>Reprehenderit.</th>
        <th>Voluptatum!</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Quidem.</th>
        <th>Blanditiis.</th>
        <th>Est!</th>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <th>Lorem.</th>
        <th>Labore.</th>
        <th>Aspernatur!</th>
        <th>Ipsum?</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Necessitatibus.</th>
        <th>Odit.</th>
        <th>Natus!</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Esse?</th>
        <th>Qui.</th>
        <th>Tempore.</th>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <th>Lorem.</th>
        <th>Iure?</th>
        <th>Tempora.</th>
        <th>Voluptates!</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Neque.</th>
        <th>Harum.</th>
        <th>A.</th>
    </tr>
    <tr>
        <th>Lorem.</th>
        <th>Aliquid!</th>
        <th>Exercitationem!</th>
        <th>Inventore?</th>
    </tr>
    </tbody>
</table>


<%--$--%>
<%--h1#header$*3--%> // $*3 : 중복되는 아이디가 생성되지 않게 순서를 붙임
<h1 id="header1"></h1>
<h1 id="header2"></h1>
<h1 id="header3"></h1>


<%--{}--%>
<%--h1{hello world}--%>
<h1>hello world</h1>

<%--div{$}*5--%>
<div>1</div>
<div>2</div>
<div>3</div>
<div>4</div>
<div>5</div>


<%--()--%>
<%--(h1>p)*3--%>
<h1>
    <p></p>
</h1>
<h1>
    <p></p>
</h1>
<h1>
    <p></p>
</h1>


</body>
</html>
