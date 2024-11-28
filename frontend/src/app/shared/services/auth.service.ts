import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = `${environment.apiBaseEndpointUrl}/auth`; // Endpoint da API Spring Boot

  constructor(private http: HttpClient) {}

  // Método para cadastrar um cliente
  cadastrarCliente(users: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, users);
  }

  // Método para fazer login
  login(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, { email, password });
  }
}
