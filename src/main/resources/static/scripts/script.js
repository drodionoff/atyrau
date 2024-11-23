document.addEventListener('DOMContentLoaded', () => {
  // Получение элементов DOM
  const inputText = document.querySelector('#inputText');
  const resultContainer = document.querySelector('.result');
  const charCount = document.querySelector('.char-count');
  const readingTimeEstimation = document.querySelector('.reading-time');

  // Функция расчёта анализа текста
  const calculateAnalysis = (text) => {
    const charCount = text.length;
    const wordCount = text.split(/\s+/).filter(Boolean).length;
    const readingTime = Math.ceil(wordCount / 2); // Средняя скорость чтения: 2 слова в секунду

    return {
      charCount,
      readingTime,
    };
  };

  // Функция обновления результатов
  const updateResults = () => {
    const text = inputText.value.trim();

    // Если поле ввода пустое, скрываем результаты
    if (!text) {
      resultContainer.classList.add('hidden');
      return;
    }

    resultContainer.classList.remove('hidden');

    const { charCount: chars, readingTime } = calculateAnalysis(text);

    charCount.textContent = `Количество символов: ${chars}`;
    readingTimeEstimation.textContent = `Примерное время на чтение текста вслух: ${readingTime} секунд`;
  };

  // Запуск обновления результатов каждую секунду
  setInterval(updateResults, 1000);

  // Инициализация: скрываем результаты при загрузке страницы
  updateResults();
});
