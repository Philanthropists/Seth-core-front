import { Moment } from 'moment';
import { IItem } from 'app/shared/model/item.model';
import { ITag } from 'app/shared/model/tag.model';
import { PostType } from 'app/shared/model/enumerations/post-type.model';

export interface IPost {
  id?: string;
  name?: string;
  type?: PostType;
  description?: string;
  publishDate?: string;
  resolvedDate?: string;
  items?: IItem[];
  tags?: ITag[];
}

export const defaultValue: Readonly<IPost> = {};
