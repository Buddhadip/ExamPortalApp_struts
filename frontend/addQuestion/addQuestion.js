const quizData = [
    {
      question: "What is the capital of India?",
      a: "Delhi",
      b: "Mumbai",
      c: "Kolkata",
      d: "Chennai",
      correct: "a",
    },
    {
      question: "What is the capital of Australia?",
      a: "Sydney",
      b: "Melbourne",
      c: "Canberra",
      d: "Perth",
      correct: "c",
    },
    {
      question: "What is the capital of USA?",
      a: "New York",
      b: "Washington DC",
      c: "Los Angeles",
      d: "Chicago",
      correct: "b",
    },
    {
      question: "What is the capital of UK?",
      a: "London",
      b: "Manchester",
      c: "Liverpool",
      d: "Birmingham",
      correct: "a",
    },
    {
      question: "What is the capital of Canada?",
      a: "Toronto",
      b: "Vancouver",
      c: "Ottawa",
      d: "Montreal",
      correct: "c",
    },
    {
      question: "What is the capital of Germany?",
      a: "Berlin",
      b: "Munich",
      c: "Frankfurt",
      d: "Hamburg",
      correct: "a",
    },
    {
      question: "What is the capital of China?",
      a: "Beijing",
      b: "Shanghai",
      c: "Guangzhou",
      d: "Hong Kong",
      correct: "a",
    },
    {
      question: "What is the capital of Brazil?",
      a: "Sao Paulo",
      b: "Rio de Janeiro",
      c: "Brasilia",
      d: "Salvador",
      correct: "c",
    },
    {
      question: "What is the capital of Japan?",
      a: "Tokyo",
      b: "Osaka",
      c: "Kyoto",
      d: "Nagoya",
      correct: "a",
    },
    {
      question: "What is the capital of France?",
      a: "Paris",
      b: "Marseille",
      c: "Lyon",
      d: "Toulouse",
      correct: "a",
    },
  ];
  
const quiz = document.getElementById("problem-section");

var quiz_html = ``;

for (let i = 0; i < quizData.length; i++) {
    quiz_html += `
        <div id="problem-${i+1}" >
        <h3>Question ${i+1}</h3>
        <div class="question">
            <p class="qtext"> ${quizData[i].question} </p>
            <label>
            <input type="radio" name="qs-${i+1}" onchange="handleRadioChange(${i+1})" disable />
            <span>${quizData[i].a} </span>
            </label>
            <label>
            <input type="radio" name="qs-${i+1}" onchange="handleRadioChange(${i+1})"  disable />
            <span>${quizData[i].b} </span>
            </label>
            <label>
            <input type="radio" name="qs-${i+1}" onchange="handleRadioChange(${i+1})"  disable />
            <span>${quizData[i].c} </span>
            </label>
            <label>
            <input type="radio" name="qs-${i+1}" onchange="handleRadioChange(${i+1})"  disable />
            <span>${quizData[i].d} </span>
            </label>
        </div>
        <div class="button-section">
        <button class="change-button2" id="delete-button"  > Delete </button>
      </div>
      <hr />
        </div>
  `;
}
quiz.innerHTML = quiz_html;


function autoResizeTextarea(element) {
    element.style.height = 'auto';
    element.style.height = element.scrollHeight + 'px';
  }

  function handleFileInputChange(input) {
    const selectedFiles = input.files;
    
    // Restrict to only one file input
    if (selectedFiles.length > 1) {
      input.value = '';
      alert('Please select only one file.');
      return;
    }
    
    // Restrict to image file input
    const file = selectedFiles[0];
    const fileType = file.type.toLowerCase();
    const allowedTypes = ['image/jpeg', 'image/png', 'image/gif'];
    if (!allowedTypes.includes(fileType)) {
      input.value = '';
      alert('Please select a valid image file (JPEG, PNG, or GIF).');
      return;
    }
    
    // Perform further processing if needed
    // ...

     // Display the selected image
     const reader = new FileReader();
     reader.onload = function(e) {
       const previewImage = document.getElementById('preview-image');
       previewImage.src = e.target.result;
     };
     reader.readAsDataURL(file);
  }