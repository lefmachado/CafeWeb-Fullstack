import { Component, OnInit } from '@angular/core';
import { CarrinhoService } from '../../services/carrinho.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-carrinho',
  standalone: true,
  imports: [CommonModule, MatIconModule],
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {
  itens: any[] = [];
  totalPedido: number = 0;

  constructor(private carrinhoService: CarrinhoService, private router: Router) {}

  ngOnInit(): void {
    this.itens = this.carrinhoService.obterItens();
    this.calcularTotal();
  }

  calcularTotal(): void {
    this.totalPedido = this.itens.reduce((acc, item) => acc + item.preco, 0);
  }

  pagamento(): void {
    this.router.navigate(['/checkout']);
  }

  continuarComprando(): void {
    this.router.navigate(['/']);
  }

  limparCarrinho(): void {
    this.itens = [];
    this.totalPedido = 0;
    this.carrinhoService.limparCarrinho(); // Assumindo que há um método para limpar no serviço
  }

  removerItem(index: number): void {
    this.itens.splice(index, 1);
    this.calcularTotal();
    this.carrinhoService.atualizarItens(this.itens); // Assumindo que há um método para atualizar no serviço
  }
}
