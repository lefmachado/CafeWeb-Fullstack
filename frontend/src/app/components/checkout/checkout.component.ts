import { Component, OnInit } from '@angular/core';
import { CarrinhoService } from '../../services/carrinho.service';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [CommonModule, MatIconModule, FormsModule],
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  itens: any[] = [];
  totalPedido: number = 0;
  formaPagamento: string = '';
  numeroCartao: string = '';
  validadeCartao: string = '';
  cvvCartao: string = '';

  constructor(private carrinhoService: CarrinhoService) {}

  ngOnInit(): void {
    this.itens = this.carrinhoService.obterItens();
    this.calcularTotal();
  }

  calcularTotal(): void {
    this.totalPedido = this.itens.reduce((acc, item) => acc + item.preco, 0);
  }

  confirmarPagamento(): void {
    if (this.formaPagamento === 'cartao' && (!this.numeroCartao || !this.validadeCartao || !this.cvvCartao)) {
      alert('Por favor, preencha todas as informações do cartão.');
      return;
    }

    // Implementar lógica para processamento de pagamento aqui
    alert('Pagamento confirmado! Pedido finalizado.');
    this.carrinhoService.limparCarrinho(); // Limpa o carrinho após finalizar o pedido
  }
}
