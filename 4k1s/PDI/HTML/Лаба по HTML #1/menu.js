/* 
		Пункты подменю. Трех-уровневый массив: 
			ПЕРВЫЙ УРОВЕНЬ - пункт меню (не задан, но подразумевается). 
				Представляет собой двухуровневый массив, в который входят все подпункты данного пункта
			ВТОРОЙ УРОВЕНЬ - подпункт меню. Простой массив, в котором хранится инфа о следующем:
				Первый элемент массива - отображаемая надпись в меню
				Второй элемент массива - URL гиперссылки
				Третий элемент массива - всплывающая подсказка
*/

var ACT	= 0
var ACT_Q = ''
var SACT = 0
var cv= ''
var SubLink=new Array()
	SubLink[0]=new Array()		// Работа со шрифтом
		SubLink[0][0]=new Array('Контейнер','CONNT/Cnt1_1.htm','Контейнер <font> ... </font>')
		SubLink[0][1]=new Array('Гарнитура', 'CONNT/Cnt1_2.htm', 'Гарнитура шрифта')
		SubLink[0][2]=new Array('Размер','CONNT/Cnt1_3.htm','Размер шрифта')
		SubLink[0][3]=new Array('Цвет текста','CONNT/Cnt1_4.htm','Цвет текста')
		SubLink[0][4]=new Array('Трансформация','CONNT/Cnt1_5.htm','Трансформация текста')
		SubLink[0][5]=new Array('Индексы','CONNT/Cnt1_6.htm','Индексы (надстрочные и подстрочные знаки)')
		SubLink[0][6]=new Array('Прочее','CONNT/Cnt1_7.htm','Другие текстовые эффекты')
		SubLink[0][7]=new Array('Задание 1','CONNT/Cnt1_8.htm','Практическое задание 1')
		SubLink[0][8]=new Array('Решение 1','CONNT/Cnt1_9.htm','Решение практического задания 1')
		SubLink[0][9]=new Array('Линия','CONNT/Cnt1_10.htm','Горизонтальная линия')
		SubLink[0][10]=new Array('Задание 2','CONNT/Cnt1_11.htm','Горизонтальная линия')

	SubLink[1]=new Array()		// Пункт Работа со списками
		SubLink[1][0]=new Array('Списки','CONNT/Cnt2_1.htm','Списки')
		SubLink[1][1]=new Array('Маркированный','CONNT/Cnt2_2.htm','Маркированный список')
		SubLink[1][2]=new Array('Маркеры','CONNT/Cnt2_3.htm','Типы маркеров')
		SubLink[1][3]=new Array('Нумерованный','CONNT/Cnt2_4.htm','Нумерованный список')
		SubLink[1][4]=new Array('Нумерация','CONNT/Cnt2_5.htm','Тип нумерации')
		SubLink[1][5]=new Array('Двухуровневый','CONNT/Cnt2_6.htm','Двухуровневый список')
		SubLink[1][6]=new Array('Задание 1','CONNT/Cnt2_7.htm','Задание 1. «Логические узлы ЭВМ»')
		SubLink[1][7]=new Array('Задание 2','CONNT/Cnt2_8.htm','Задание 2. «Принципы фон Неймана»')
		SubLink[1][8]=new Array('Задание 3','CONNT/Cnt2_9.htm','Задание 3. «Память»')
		SubLink[1][9]=new Array('Задание 4','CONNT/Cnt2_10.htm','Задание 4. «Монитор»')
		SubLink[1][10]=new Array('Задание 5','CONNT/Cnt2_11.htm','Задание 5. «Процессор»')

	SubLink[2]=new Array()		// Пункт Графика
		SubLink[2][0]=new Array('Графика','CONNT/Cnt3_1.htm','Графические форматы')
		SubLink[2][1]=new Array('Тег &lt;IMG&gt;','CONNT/Cnt3_2.htm','Тег &lt;IMG&gt;')
		SubLink[2][2]=new Array('Замещающий текст','CONNT/Cnt3_3.htm','Замещающий текст')
		SubLink[2][3]=new Array('Подсказка','CONNT/Cnt3_4.htm','Всплывающая подсказка')
		SubLink[2][4]=new Array('Размеры','CONNT/Cnt3_5.htm','Управление размерами отображаемой картинки')
		SubLink[2][5]=new Array('Обрамление','CONNT/Cnt3_6.htm','Обрамление отображаемой картинки')
		SubLink[2][6]=new Array('Поля','CONNT/Cnt3_7.htm','Задание полей вокруг картинки')
		SubLink[2][7]=new Array('Выравнивание','CONNT/Cnt3_8.htm','Выравнивание картинки')
		SubLink[2][8]=new Array('Задание 1','CONNT/Cnt3_9.htm','Задание 1. «Заготовка рисунков для будущего проекта»')
		SubLink[2][9]=new Array('Задание 2','CONNT/Cnt3_10.htm','Задание 2. «Вставка картинок в документ»')

	SubLink[3]=new Array()		// Пункт Таблицы
		SubLink[3][0]=new Array('Таблицы','CONNT/Cnt4_1.htm','Работа с таблицами')
		SubLink[3][1]=new Array('&lt;table&gt...&lt;/table&gt;','CONNT/Cnt4_2.htm','Контейнер &lt;table&gt...&lt;/table&gt;')
		SubLink[3][2]=new Array('&lt;tr&gt...&lt;/tr&gt;','CONNT/Cnt4_3.htm','Контейнер &lt;tr&gt...&lt;/tr&gt;')
		SubLink[3][3]=new Array('&lt;td&gt...&lt;/td&gt;','CONNT/Cnt4_4.htm','Контейнер &lt;td&gt...&lt;/td&gt;')
		SubLink[3][4]=new Array('Задание 1','CONNT/Cnt4_5.htm','Создание простой таблицы')
		SubLink[3][5]=new Array('Задание 2','CONNT/Cnt4_6.htm','Создание отформатированной таблицы')
		SubLink[3][6]=new Array('Задание 3','CONNT/Cnt4_7.htm','Таблица с рисунками')

	SubLink[4]=new Array()		// Пункт Ссылки
		SubLink[4][0]=new Array('Ссылки','CONNT/Cnt5_1.htm','Работа с гиперссылками')
		SubLink[4][1]=new Array('Тег &lt;a&gt;...&lt;/a&gt;','CONNT/Cnt5_2.htm','Тег &lt;a&gt;...&lt;/tr&gt;')
		SubLink[4][2]=new Array('Задание 1','CONNT/Cnt5_3.htm','Внутренние гиперссылки')
		SubLink[4][3]=new Array('Задание 2','CONNT/Cnt5_4.htm','Внутренние гиперссылки')
		SubLink[4][4]=new Array('Сайт','CONNT/Cnt5_5.htm','Понятие о сайте')
		SubLink[4][5]=new Array('Задание 3','CONNT/Cnt5_6.htm','Создание сайта')

	SubLink[5]=new Array()		// Пункт Фреймы
		SubLink[5][0]=new Array('Понятие','CONNT/Cnt6_1.htm','Понятие о фреймовых структурах')
		SubLink[5][1]=new Array('&lt;iframe&gt...&lt;/iframe&gt;','CONNT/Cnt6_2.htm','Плавающие фреймы')
		SubLink[5][2]=new Array('Тег <b>frameset</b>','CONNT/Cnt6_3.htm','Обыкновенные фреймы')
		SubLink[5][3]=new Array('Задание 1','CONNT/Cnt6_4.htm','Сайт на основе плавающего фрейма')
		SubLink[5][4]=new Array('Задание 2','CONNT/Cnt6_5.htm','Сайт на основе обыкновенных фреймов')
	
	
var GlavLink=new Array('Работа со шрифтом','Работа со списками','Работа с графикой', 'Работа с таблицами', 'Гиперссылки', 'Фреймы')		// пункты меню 
	
// подсвечивание активного пункта меню заливкой
function VOZVRAT(P){
for(i=1;i<=GlavLink.length;i++){i==ACT?'':document.getElementById(('pn')+i).style.background='#E0E0E0'}
P==ACT?document.getElementById(('pn')+P).style.background='url(PICT/blue_act.png)':document.getElementById(('pn')+P).style.background='url(PICT/blue.png)'
}

function polz(Numb,Count){
//alert(Numb+","+Count);
var i=1;
VOZVRAT(Numb);
setInterval(function() 
	{
		if (i<=Count)
			{
			document.getElementById(('pn'+Numb+'_')+i).style.display=='block'?document.getElementById(('pn'+Numb+'_')+i).style.display='none':document.getElementById(('pn'+Numb+'_')+i).style.display='block'
			setTimeout(arguments.callee, 70);
			document.getElementById(('pn'+Numb+'_')+i).style.background=''
			i++
			}
	}, 50);
}

// плавное выползание подпунктов меню
function MENU(P,Q){
ACT==0 && ACT_Q==0?'':polz(ACT,ACT_Q);
ACT=P;			// номер активного пункта меню
ACT_Q=Q;
polz(ACT,ACT_Q);
}

// рисование пунктов меню
for(j=1;j<=GlavLink.length;j++){
document.write("<div class=pnkt id=pn"+j+" onmouseover=\"VOZVRAT("+j+")\" onclick=\"MENU("+j+","+SubLink[(j-1)].length+")\">"+GlavLink[j-1]+"</div>")	
	for(i=0;i<SubLink[j-1].length;i++){
	document.write("\n<a title='"+SubLink[j-1][i][2]+"' class=subm id=pn"+j+"_"+(i+1)+" href=# onclick=\"document.getElementById('freim').src='"+SubLink[j-1][i][1]+"';this.style.background='#ccee33'\">"+SubLink[j-1][i][0]+"</a>") 
	}
}



