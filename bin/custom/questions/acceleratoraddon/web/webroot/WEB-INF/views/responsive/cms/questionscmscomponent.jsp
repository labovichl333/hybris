<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>

<div class="questionsCMSComponent" style="font-size: ${fontSize}px">
    <h1 class="questionsCMSComponent_title">Question&Answer</h1>
    <c:if test="${empty product.questions}">
        <div>No questions yet.</div>
    </c:if>
    <c:forEach items="${product.questions}" var="question" begin="0" end="${questionsNumber-1}">
        <div class="questionsCMSComponent_question"> Question:</div>
        <div class="questionsCMSComponent_question_text">${question.question}</div>
        <div class="questionsCMSComponent_author">By ${question.questionCustomer}</div>
        <c:if test="${not empty question.answer}">
            <div class="questionsCMSComponent_answer"> Answer:</div>
            <div class="questionsCMSComponent_answer_text">${question.answer}</div>
            <div class="questionsCMSComponent_author">By ${question.answerCustomer}</div>
        </c:if>
        <br>
    </c:forEach>
</div>
