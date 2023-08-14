

window.addEventListener('load', function(e){
	console.log('page loaded');
	init();
});

function init() {
	loadMacros();
	getMacrosDetails(1);

document.addMacros.createMacroButton.addEventListener('click', function(event){
	event.preventDefault();
	console.log('Adding Macros');
	let form = document.newaddMacros;
	console.log(form);
	createMacros();
});

document.addMacros.updateMacroButton.addEventListener('click', function(event) {
   event.preventDefault();
   console.log('Updating Macros');
   let form = document.getElementById('newMacrosForm');
   let macroId = form.id.value;
   console.log('macroId: ' +  macroId)
   updateMacros(macroId);
});

document.addMacros.deleteMacroButton.addEventListener('click', function(event){
	event.preventDefault();
	console.log('deleting macro');
	let form = document.getElementById('newMacrosForm');
	let macroId = form.id.value;
	deleteMacro(macroId);
})

}




function loadMacros () {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/macros');
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4) {
			if(xhr.status === 200) {
				let macros = JSON.parse(xhr.responseText);
				displayMacros(macros);
				console.log(macros);
			}else {
				
			}
		}
		
	};
	
	xhr.send();
}

function displayMacros(macrosList){
	if(macrosList && Array.isArray(macrosList)) {
		let tbody = document.getElementById("macrosTableBody");
		for(let macros of macrosList) {
			let tr = document.createElement('tr');
			let td = document.createElement('td');
			td.textContent = macros.id;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = macros.food;
			tr.appendChild(td);
			tbody.appendChild(tr);
			
			 tr.addEventListener('click', function() {
                getMacrosDetails(macros.id);
            });
		}
	}
	
}
function getMacrosDetails(macrosId){
	let xhr = new XMLHttpRequest();
    xhr.open('GET', 'api/macros/' + macrosId);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let macros = JSON.parse(xhr.responseText);
                displayMacrosDetails(macros);
                let form = document.addMacros;
                form.id.value = macros.id;
                form.food.value = macros.food;
                form.protein.value = macros.protein;
                form.fat.value = macros.fat;
                form.carbohydrates.value = macros.carbohydrates;
                form.calories.value = macros.calories;
                form.servingSize.value = macros.servingSize;
                form.numOfServings.value = macros.numOfServings;
                form.meal.value = macros.meal;
                
                
                
            } else {
                console.error('error retrieving macros' + xhr.status)
            }
        }
    };
    xhr.send();
}


function displayMacrosDetails(macros){
	let macrosDetailsDiv = document.getElementById('macrosDetailsDiv');
    macrosDetailsDiv.textContent = '';

    let title = document.createElement('h1');
    title.textContent = 'Macro Details';
    macrosDetailsDiv.appendChild(title);

    let infoList = document.createElement('ul');

    let id = document.createElement('li');
    id.textContent = 'ID: ' + macros.id;
    infoList.appendChild(id);

    let food = document.createElement('li');
    food.textContent = 'Food: ' + macros.food;
    infoList.appendChild(food);

    let protein = document.createElement('li');
    protein.textContent = 'Protein: ' + macros.protein;
    infoList.appendChild(protein); 
    
    let fat = document.createElement('li');
    fat.textContent = 'Fat: ' + macros.fat;
    infoList.appendChild(fat);
    
    let carbohydrates = document.createElement('li');
    carbohydrates.textContent = 'Carbohydrates: ' + macros.carbohydrates;
    infoList.appendChild(carbohydrates);
    
    let calories = document.createElement('li');
    calories.textContent = 'Calories: ' + macros.calories;
    infoList.appendChild(calories);
    
    let servingSize = document.createElement('li');
    servingSize.textContent = 'Serving Size: ' + macros.servingSize;
    infoList.appendChild(servingSize);
    
    let numOfServings = document.createElement('li');
    numOfServings.textContent = 'Number of Servings: ' + macros.numOfServings;
    infoList.appendChild(numOfServings);
    
    let meal = document.createElement('li');
    meal.textContent = 'Meal: ' + macros.meal;
    infoList.appendChild(meal);

    macrosDetailsDiv.appendChild(infoList);

}
function createMacros() {
		let form = document.addMacros;
        let food = form.food.value;
        let protein = form.protein.value;
        let fat = form.fat.value;
        let carbohydrates = form.carbohydrates.value;
        let calories = form.calories.value;
        let servingSize = form.servingSize.value;
        let numOfServings = form.numOfServings.value;
        let meal = form.meal.value;

        let macro = {
            food: food,
            protein: protein,
            fat: fat,
            carbohydrates: carbohydrates,
            calories: calories,
            servingSize: servingSize,
            numOfServings: numOfServings,
            meal: meal
        };

        let xhr = new XMLHttpRequest();
        xhr.open('POST', 'api/macros');

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 201) {
                    let createdMacro = JSON.parse(xhr.responseText);
                    displayMacros(createdMacro); 
                    console.log('Macro created successfully');
                    
                } else {
                    console.error('Error with macro creation: ' + xhr.status);
                }
            }
        };

        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(JSON.stringify(macro));
        window.location.reload();

}

function updateMacros(macrosId) {
	let form = document.addMacros;
    let food = form.food.value;
    let protein = form.protein.value;
    let fat = form.fat.value;
    let carbohydrates = form.carbohydrates.value;
    let calories = form.calories.value;
    let servingSize = form.servingSize.value;
    let numOfServings = form.numOfServings.value;
    let meal = form.meal.value;
    
    let updatedMacroData = {
        food: food,
        protein: protein,
        fat: fat,
        carbohydrates: carbohydrates,
        calories: calories,
        servingSize: servingSize,
        numOfServings: numOfServings,
        meal: meal
    };

    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'api/macros/' + macrosId); 
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let updatedMacro = JSON.parse(xhr.responseText);
                console.log('Macro updated successfully');
            } else {
                console.error('Error with macro update: ' + xhr.status);
            }
        }
    };
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(updatedMacroData));
    window.location.reload();
}

function deleteMacro(macrosId) {
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE',`api/macros/${macrosId}`);
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4) {
			if(xhr.status === 204) {
				console.log('macro has been deleted');
				removeMacrosFromList(parseInt(macrosId));
			}else {
				console.log('Error deleting macros' + xhr.status)
			}
		}
	}
	xhr.send();
	window.location.reload();
};


function removeMacrosFromList(deletedMacroId) {
  let rowToDelete = document.querySelector(`tr[data-macro-id="${deletedMacroId}"]`);
    if (rowToDelete) {
        rowToDelete.remove();
    }
}


function calculateTotalCalories(macrosList) {
	let totalCalories = 0;
	for (let macro of macrosList) {
		totalCalories += parseInt(macro.calories);
	}
	return totalCalories;
}

function displayTotalCalories(totalCalories) {
	let totalCaloriesContainer = document.getElementById('totalCalories');
	totalCaloriesContainer.textContent = 'Total Calories: ' + totalCalories;
}




















