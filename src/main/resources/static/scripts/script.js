// Получаем элементы из DOM
const inputText = document.getElementById('inputText');
const analyzeButton = document.querySelector('.analyze-button');
const clearButton = document.querySelector('.clear-button');
const resultDiv = document.querySelector('.result');

const countWordsCheckbox = document.getElementById('countWords');
const countCharsWithSpacesCheckbox = document.getElementById('countCharsWithSpaces');
const readingTimeCheckbox = document.getElementById('readingTime');

const readingSpeedRadios = document.getElementsByName('readingSpeed');

const wordCountElem = document.querySelector('.word-count');
const charCountWithSpacesElem = document.querySelector('.char-count-with-spaces');
const readingTimeElem = document.querySelector('.reading-time');

let lastAnalyzedText = ''; // Переменная для хранения последнего текста
let isAnalysisEnabled = false; // Флаг для активации анализа

// Функция для обновления состояния кнопки анализа
function updateAnalyzeButtonState() {
  const text = inputText.value.trim();
  analyzeButton.disabled = text.length === 0;
  if (text.length > 0) {
    clearButton.classList.remove('hidden');
  } else {
    clearButton.classList.add('hidden');
  }
}

// Функция для обновления состояния радиокнопок
function updateRadioButtonsState() {
  const isReadingTimeChecked = readingTimeCheckbox.checked;

  for (const radio of readingSpeedRadios) {
    radio.disabled = !isReadingTimeChecked;
  }
}

// Функция для анализа текста
function analyzeText() {
  const text = inputText.value.trim();

  // Если текст пуст, очищаем результаты и выходим
  if (text.length === 0) {
    resultDiv.classList.add('hidden');
    wordCountElem.textContent = '';
    charCountWithSpacesElem.textContent = '';
    readingTimeElem.textContent = '';
    return;
  }

  // Обновляем переменную с последним текстом
  lastAnalyzedText = text;

  // Очищаем предыдущие результаты
  wordCountElem.textContent = '';
  charCountWithSpacesElem.textContent = '';
  readingTimeElem.textContent = '';

  // Показываем блок результатов
  resultDiv.classList.remove('hidden');

  // Анализируем текст в зависимости от выбранных опций
  if (countWordsCheckbox.checked) {
    const words = text.split(/\s+/).filter(word => word.length > 0);
    wordCountElem.textContent = `Количество слов: ${words.length}`;
  }

  if (countCharsWithSpacesCheckbox.checked) {
    const charCount = text.length;
    charCountWithSpacesElem.textContent = `Количество символов (с пробелами): ${charCount}`;
  }

  if (readingTimeCheckbox.checked) {
    let readingSpeed = 'normal'; // Значение по умолчанию
    for (const radio of readingSpeedRadios) {
      if (radio.checked) {
        readingSpeed = radio.value;
        break;
      }
    }

    const charCount = text.length;
    let speed = 3; // Нормальная скорость по умолчанию

    if (readingSpeed === 'slow') {
      speed = 2;
    } else if (readingSpeed === 'fast') {
      speed = 5;
    }

    const timeInSeconds = charCount / speed;
    const minutes = Math.floor(timeInSeconds / 60);
    const seconds = Math.ceil(timeInSeconds % 60);

    let timeString = 'Время для чтения вслух: ';
    if (minutes > 0) {
      timeString += `${minutes} мин `;
    }
    timeString += `${seconds} сек`;

    readingTimeElem.textContent = timeString;
  }
}

// Обработчик для кнопки анализа
analyzeButton.addEventListener('click', () => {
  isAnalysisEnabled = true; // Включаем анализ
  analyzeText(); // Выполняем анализ с учетом текущих настроек
});

// Обработчик для кнопки очистки
clearButton.addEventListener('click', () => {
  inputText.value = '';
  resultDiv.classList.add('hidden');
  clearButton.classList.add('hidden');
  lastAnalyzedText = ''; // Сброс последнего текста
  isAnalysisEnabled = false; // Отключаем анализ
  updateAnalyzeButtonState();
});

// Добавляем обработчик события для ввода текста
inputText.addEventListener('input', () => {
  updateAnalyzeButtonState(); // Обновляем состояние кнопки при вводе текста
});

// Добавляем обработчик события для чекбокса "Время озвучивания текста"
readingTimeCheckbox.addEventListener('change', () => {
  updateRadioButtonsState();
});

// Инициализируем состояние кнопки анализа и радиокнопок при загрузке страницы
updateAnalyzeButtonState();
updateRadioButtonsState();
