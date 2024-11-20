import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule, MatToolbarModule, MatButtonModule], // Importa os módulos necessários
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'] // Corrigido para "styleUrls" no plural
})
export class HeaderComponent {

}
