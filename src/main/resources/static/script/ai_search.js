// html Elems
// Img Upload
const lectureButtons = document.querySelectorAll(
  ".search-area__step1 ul li button"
);
const lectureSpans = document.querySelectorAll(
  ".search-area__step1 ul li span"
);
const chooseFile = document.querySelector("#choose-file");
const imgUpload = document.querySelector(".img-upload");
const searchBtn = document.querySelector(".search-btn");
const searchBtnLabel = document.querySelector(".search-btn label");

// Img Loading
const imgLoading = document.querySelector(".img-loading");

// Result success
const resultSuccess = document.querySelector(".result-success");

// Section Content
const sectionContent = document.querySelector(".section-content");

// 찾고 싶은 강의 선택 버튼 누르기
$(".search-area__step1 ul li button").click(function (e) {
  $(this).toggleClass("clicked").next().toggleClass("clicked");
});

// 찾고 싶은 강의 선택 버튼 안누르고 이미지 업로드하면 경고창
$(".search-btn label").click(function (e) {
  if (!$(".search-area__step1 ul li button").hasClass("clicked")) {
    $("#choose-file").attr("disabled", "true");
    alert("찾고 싶은 강의를 선택해주세요.");
  } else {
    $("#choose-file").removeAttr("disabled");
  }
});

// '이미지 업로드' 버튼 누르면 이미지 분석 로딩
$("#choose-file").change(function (e) {
  $(".img-upload").css("visibility", "hidden");
  $(".img-loading").css("visibility", "visible");
  $(".section-content").css("display", "none");

  // 이미지 분석 끝나면(1초 후) 결과 보여주기
  setTimeout(() => {
    $(".img-loading").css("visibility", "hidden");
    $(".result-success").css("visibility", "visible");
  }, 1000);
});

// 이미지 업로드하면 이미지 보여주기
chooseFile.addEventListener("change", getImageFiles);

function getImageFiles(e) {
  const uploadFiles = [];
  const files = e.currentTarget.files;
  const imagePreview = document.querySelector(".lecture-recommend__img");

  // 파일 타입 검사
  [...files].forEach((file) => {
    // 파일 갯수 검사
    uploadFiles.push(file);
    const reader = new FileReader();
    reader.onload = (e) => {
      const preview = createElement(e, file);
      imagePreview.appendChild(preview);
    };
    reader.readAsDataURL(file);
  });
}

function createElement(e, file) {
  const div = document.createElement("div");
  const img = document.createElement("img");
  img.setAttribute("src", e.target.result);
  img.setAttribute("data-file", file.name);
  div.appendChild(img);

  div.style.order = "-1";
  div.style.width = "440px";
  div.style.border = "1px solid #A1A1A1";
  div.style.borderRadius = "30px";

  img.style.width = `380px`;
  img.style.display = "block";
  img.style.margin = "30px auto";
  img.style.borderRadius = "30px";

  return div;
}
