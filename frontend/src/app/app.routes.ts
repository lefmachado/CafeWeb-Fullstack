import { Routes } from '@angular/router';
import { CatalogoComponent } from './public/catalogo/catalogo.component';
import { ProdutoComponent } from './public/produto/produto.component';
import { CarrinhoComponent } from './public/carrinho/carrinho.component';
import { CheckoutComponent } from './public/checkout/checkout.component';

export const routes: Routes = [
  { path: '', component: CatalogoComponent },
  { path: 'produto/:id', component: ProdutoComponent },
  { path: 'carrinho', component: CarrinhoComponent },
  { path: 'checkout', component: CheckoutComponent },
];
