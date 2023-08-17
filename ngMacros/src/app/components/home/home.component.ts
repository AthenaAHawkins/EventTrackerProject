import { Macros } from './../../models/macros';
import { MacroService } from './../../services/macro.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  macrosList: Macros[] = [];

  constructor(private macrosService: MacroService){}

  ngOnInit(): void {
    this.reload();

  }

  reload(){
    this.macrosService.index().subscribe({
      next:(macroList)=> {
        this.macrosList = macroList;
      },
      error: (somethingBad) => {
        console.error('TodoListComponent.reload: error loading')
        console.error(somethingBad);
      }
    })
  }

}
