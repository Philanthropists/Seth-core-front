import { IPost } from 'app/shared/model/post.model';

export interface ITag {
  id?: string;
  name?: string;
  post?: IPost;
}

export const defaultValue: Readonly<ITag> = {};
