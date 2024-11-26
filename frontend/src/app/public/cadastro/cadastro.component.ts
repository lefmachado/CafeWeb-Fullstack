import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../shared/services/auth.service';
import { Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [
    ReactiveFormsModule,    // Para Formulários Reativos
    MatFormFieldModule,     // Campo de formulário Angular Material
    MatInputModule,         // Entrada de dados Angular Material
    MatButtonModule,        // Botão Angular Material
    MatCardModule,          // Card Angular Material
    CommonModule            // Necessário para diretivas como ngIf
  ],
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  cadastroForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    public router: Router
  ) {
    this.cadastroForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  cadastrar(): void {
    if (this.cadastroForm.valid) {
      this.authService.cadastrarCliente(this.cadastroForm.value).subscribe({
        next: () => {
          alert('Cadastro realizado com sucesso!');
          this.router.navigate(['/login']); // Redireciona para a página de login
        },
        error: (err) => {
          console.error(err);
          alert('Erro ao realizar cadastro!');
        }
      });
    } else {
      alert('Por favor, preencha os campos corretamente.');
    }
  }
}
