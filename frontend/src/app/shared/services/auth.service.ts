import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/clientes'; // Endpoint da API Spring Boot

  constructor(private http: HttpClient) {}

  // Método para cadastrar um cliente
  cadastrarCliente(cliente: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/cadastrar`, cliente);
  }

  // Método para fazer login
  login(email: string, senha: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, { email, senha });
  }
}
