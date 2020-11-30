import { IPost } from 'app/shared/model/post.model';

export interface IItem {
  id?: string;
  name?: string;
  resolved?: boolean;
  post?: IPost;
}

export const defaultValue: Readonly<IItem> = {
  resolved: false,
};
