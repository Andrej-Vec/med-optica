export interface ProductCard {
  title: string;
  describe: string;
  ratingValue: string;
  ratingInfo: string;
  priceCurrent: string;
  pricePrevious?: string;
  priceDifference?: string;
  priceAktsiya?: string;
  price?: string;
  isNew: boolean;
  isBestseller: boolean;
}
