// 로그인 ajax
let loginFormArray = $("#login-form").serializeArray();
let loginFormObject = {};
for (let i = 0; i < loginFormArray.length; i++) {
  loginFormObject[loginFormArray[i]["name"]] = loginFormArray[i]["value"];
}

$("#login-submit").submit(function (e) {
  $.ajax({
    type: "post",
    url: "http://localhost:8080/api/user/login",
    data: {
      loginFormObject,
    },
    dataType: "json",
    success: function (response) {
      alert();
    },
  });
});

// 회원가입 ajax
let registerFormArray = $("#register-form").serializeArray();
let registerFormObject = {};
for (let i = 0; i < registerFormArray.length; i++) {
  registerFormObject[registerFormArray[i]["name"]] =
    registerFormArray[i]["value"];
}

$("#register-submit").submit(function (e) {
  $.ajax({
    type: "post",
    url: "http://localhost:8080/api/user/create",
    data: {
      registerFormObject,
    },
    dataType: "json",
    success: function (response) {
      alert();
    },
  });
});

// 이메일로 회원가입 버튼 클릭
$(".register-with-email").click(function (e) {
  $(".login-container__login-form").css("display", "none");
  $(".register-container").css("display", "block");

});

// 이메일로 회원가입 완료하기 버튼 클릭
$.ajax({
  type: "method",
  url: "url",
  data: "data",
  dataType: "dataType",
  success: function (response) {
    // .register-container__check 보여주기
  }
});